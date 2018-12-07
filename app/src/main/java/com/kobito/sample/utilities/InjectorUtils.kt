package com.kobito.sample.utilities

import com.kobito.sample.data.FakeDatabase
import com.kobito.sample.data.QuoteRepository
import com.kobito.sample.ui.quotes.QuotesViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteDao = FakeDatabase.getInstance().quoteDao
        val quoteRepository = QuoteRepository.getInstance(quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}