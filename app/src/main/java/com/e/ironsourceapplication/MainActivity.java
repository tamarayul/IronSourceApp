package com.e.ironsourceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialListener;

public class MainActivity extends AppCompatActivity implements InterstitialListener{

    private final String TAG = "MainActivity";
    private final String APP_KEY = "85460dcd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntegrationHelper.validateIntegration(this);
        initIronSource(APP_KEY);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IronSource.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        IronSource.onPause(this);
    }

    private void initIronSource(String appKey) {
        IronSource.setInterstitialListener(this);
        IronSource.init(this, appKey, IronSource.AD_UNIT.INTERSTITIAL);
        IronSource.loadInterstitial();
    }


    @Override
    public void onInterstitialAdReady() {
        Log.d(TAG, "onInterstitialAdReady");
        IronSource.showInterstitial();
    }

    @Override
    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        Log.d(TAG, "onInterstitialAdLoadFailed" + " " + ironSourceError);
    }

    @Override
    public void onInterstitialAdOpened() {
        Log.d(TAG, "onInterstitialAdOpened");
    }

    @Override
    public void onInterstitialAdClosed() {
        Log.d(TAG, "onInterstitialAdClosed");
    }

    @Override
    public void onInterstitialAdShowSucceeded() {
        Log.d(TAG, "onInterstitialAdShowSucceeded");
    }

    @Override
    public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
        Log.d(TAG, "onInterstitialAdShowFailed" + " " + ironSourceError);
    }

    @Override
    public void onInterstitialAdClicked() {
        Log.d(TAG, "onInterstitialAdClicked");
    }
}