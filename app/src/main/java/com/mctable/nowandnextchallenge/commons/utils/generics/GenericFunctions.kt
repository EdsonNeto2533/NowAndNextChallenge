package com.mctable.nowandnextchallenge.commons.utils.generics

object GenericFunctions {

    fun getImage(title: String, callLetter: String) =
        "http://cdn-images.online.meo.pt/eemstb/ImageHandler.ashx?evTitle=$title&chCallLetter=$callLetter&profile=16_9&width=320"

    fun getProgramEndpoint(callLetter: String) =
        "Program/v9/Programs/NowAndNextLiveChannelPrograms?UserAgent=AND&${'$'}filter=CallLetter%20eq%20%27$callLetter%27&${'$'}orderby=StartDate%20asc"
}