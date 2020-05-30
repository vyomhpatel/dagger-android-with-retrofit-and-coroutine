package com.vyom.practice.data.model

object Model {
    data class Data(val query: Query)
    data class Query(val searchinfo: SearchInfo)
    data class SearchInfo(val totalhits: Int)
}