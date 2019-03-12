package com.wajdihh.data.mapper

import com.wajdihh.data.model.json.UserJson
import com.wajdihh.domain.model.User

/**
 * Created by wajdihh on 3/12/19.
 * Map user Data to User model
 */


fun UserJson.toUser() = User(firstName = firstName,
        lastName = lastName,
        lastSignInAt = lastSignInAt,
        profilePictureUrl = profilePictureUrl,
        profileThumbUrl = thumbPictureUrl)