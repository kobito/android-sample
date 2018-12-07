package com.kobito.sample.ui.quotes

import androidx.lifecycle.ViewModel
import com.kobito.sample.data.Quote
import com.kobito.sample.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}