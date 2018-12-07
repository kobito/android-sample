package com.kobito.sample.data.repository

import androidx.lifecycle.LiveData
import com.kobito.sample.data.model.Quote

interface QuoteRepository {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}