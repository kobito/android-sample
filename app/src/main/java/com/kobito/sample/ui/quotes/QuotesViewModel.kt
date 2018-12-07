package com.kobito.sample.ui.quotes

import androidx.lifecycle.ViewModel
import com.kobito.sample.data.model.Quote
import com.kobito.sample.data.repository.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)

    fun getQuotes() = quoteRepository.getQuotes()
}