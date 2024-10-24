package com.api.myfilelocker.ui.screens

import android.annotation.SuppressLint
import androidx.media3.exoplayer.offline.DownloadManager
import kotlinx.coroutines.delay


const val DOWNLOAD_SUCCESS = 100L
const val DOWNLOAD_FAILED = -100L

class DownloadProgressUpdater(
    private val manager: android.app.DownloadManager,
    private val downloadId: Long,
    private var listener: DownloadProgressListener
) {
    private val query = android.app.DownloadManager.Query()
    private var totalBytes = 0

    init {
        query.setFilterById(downloadId)
    }

    @SuppressLint("Range")
    suspend fun run() {

        while (downloadId > 0) {
            delay(250)

            manager.query(query).use { cursor ->

                if (cursor.moveToFirst()) {


                    if (totalBytes <= 0)
                        totalBytes =
                            cursor.getInt(cursor.getColumnIndex(android.app.DownloadManager.COLUMN_TOTAL_SIZE_BYTES))

                    val downloadStatus =
                        cursor.getInt(cursor.getColumnIndex(android.app.DownloadManager.COLUMN_STATUS))
                    val bytesDownloadSoFar =
                        cursor.getInt(cursor.getColumnIndex(android.app.DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR))

                    when (downloadStatus) {
                        android.app.DownloadManager.STATUS_SUCCESSFUL -> {
                            listener.updateProgress(DOWNLOAD_SUCCESS)
                            return
                        }

                        android.app.DownloadManager.STATUS_FAILED -> {
                            listener.updateProgress(DOWNLOAD_FAILED)
                            return
                        }

                        else -> {
                            val downloadProgress = bytesDownloadSoFar * 100L / totalBytes
                            listener.updateProgress(downloadProgress)
                        }
                    }
                }
            }
        }
    }


    interface DownloadProgressListener {
        fun updateProgress(progress: Long)
    }
}