package com.volnoor.lib_webrtc_test.data

import android.os.Parcel
import android.os.Parcelable

data class RoomConfiguration(
    val roomUrl: String,
    val roomId: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(roomUrl)
        parcel.writeString(roomId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RoomConfiguration> {
        override fun createFromParcel(parcel: Parcel): RoomConfiguration {
            return RoomConfiguration(parcel)
        }

        override fun newArray(size: Int): Array<RoomConfiguration?> {
            return arrayOfNulls(size)
        }
    }
}