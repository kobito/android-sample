package com.kobito.sample.data.db

import androidx.lifecycle.LiveData
import com.kobito.sample.data.model.Quote

interface QuoteDao {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}