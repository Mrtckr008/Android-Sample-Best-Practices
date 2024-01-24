package com.mrtckr.livecoding2

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class LiveCodingApplication @Inject constructor() : Application()