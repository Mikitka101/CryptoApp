package com.nikitayasiulevich.cryptoapp.presentation

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.nikitayasiulevich.cryptoapp.R
import com.nikitayasiulevich.cryptoapp.databinding.ActivityCoinPriceListBinding
import com.nikitayasiulevich.cryptoapp.domain.CoinInfo
import com.nikitayasiulevich.cryptoapp.presentation.adapters.CoinInfoAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoinPriceListActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCoinPriceListBinding.inflate(layoutInflater)
    }
    private lateinit var viewModel: CoinViewModel
    private var isFragmentOpened: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = CoinInfoAdapter(this)
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinInfoDto: CoinInfo) {
                if (isOnePainMode()) {
                    launchDetailActivity(coinInfoDto.fromSymbol)
                } else {
                    launchDetailFragment(coinInfoDto.fromSymbol)
                }
            }
        }

        val callback = object : OnBackPressedCallback(
            true // default to enabled
        ) {
            override fun handleOnBackPressed() {
                if (isFragmentOpened) {
                    fragmentAnimation(needToBeReversed = true)
                    isFragmentOpened = false
                    CoroutineScope(Dispatchers.Default).launch {
                        delay(1000)
                        supportFragmentManager.popBackStack()
                    }
                } else {
                    finish()
                }
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)

        binding.rvCoinPriceList.adapter = adapter
        binding.rvCoinPriceList.itemAnimator = null
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.coinInfoList.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun isOnePainMode() = binding.fragmentContainer == null

    private fun launchDetailActivity(fromSymbol: String) {
        val intent = CoinDetailActivity.newIntent(
            this@CoinPriceListActivity,
            fromSymbol
        )
        startActivity(intent)
    }

    private fun launchDetailFragment(fromSymbol: String) {
        supportFragmentManager.popBackStack()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, CoinDetailFragment.newInstance(fromSymbol))
            .addToBackStack(null)
            .commit()

        if (!isFragmentOpened) {
            fragmentAnimation()
            isFragmentOpened = true
        }
    }

    private fun fragmentAnimation(duration: Long = 1000, needToBeReversed: Boolean = false) {
        var startPercent = 1.0f
        var endPercent = 0.5f
        if(needToBeReversed){
            val temp = startPercent
            startPercent = endPercent
            endPercent = temp
        }
        val animator =
            ObjectAnimator.ofFloat(binding.middleOfScreen, "guidelinePercent", startPercent, endPercent)
        animator.duration = duration
        animator.start()
    }
}