package com.wajdihh.modelq.extension

import android.os.Bundle


fun bundle(args: Bundle.() -> Unit) = Bundle().apply(args)
