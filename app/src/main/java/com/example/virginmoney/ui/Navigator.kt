/**
 * Copyright (C) 2020 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.virginmoney.ui

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.FragmentActivity
import com.example.virginmoney.di.ApplicationModule
import com.example.virginmoney.ui.list.MainActivity
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Navigator @Inject constructor() {

    fun showUserList(context: Context) =
        context.startActivity(MainActivity.callingIntent(context))

//    fun showMovieDetails(activity: FragmentActivity, movie: MovieView, navigationExtras: Extras) {
//        val intent = MovieDetailsActivity.callingIntent(activity, movie)
//        val sharedView = navigationExtras.transitionSharedElement as ImageView
//        val activityOptions = ActivityOptionsCompat
//            .makeSceneTransitionAnimation(activity, sharedView, sharedView.transitionName)
//        activity.startActivity(intent, activityOptions.toBundle())
//    }


//    fun openVideo(context: Context, videoUrl: String) {
//        try {
//            context.startActivity(createYoutubeIntent(videoUrl))
//        } catch (ex: ActivityNotFoundException) {
//            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl)))
//        }
//    }

//    private fun createYoutubeIntent(videoUrl: String): Intent {
//        val videoId = when {
//            videoUrl.startsWith(VIDEO_URL_HTTP) -> videoUrl.replace(VIDEO_URL_HTTP, String.empty())
//            videoUrl.startsWith(VIDEO_URL_HTTPS) -> videoUrl.replace(
//                VIDEO_URL_HTTPS,
//                String.empty()
//            )
//            else -> videoUrl
//        }
//
//        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$videoId"))
//        intent.putExtra("force_fullscreen", true)
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//
//        return intent
//    }

    class Extras(val transitionSharedElement: View)
}


