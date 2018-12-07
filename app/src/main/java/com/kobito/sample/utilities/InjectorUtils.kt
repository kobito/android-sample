package com.kobito.sample.utilities

import com.kobito.sample.data.db.DatabaseFakeImpl
import com.kobito.sample.data.repository.QuoteRepositoryImpl
import com.kobito.sample.ui.quotes.QuotesViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteDao = DatabaseFakeImpl().quoteDao
        val quoteRepository = QuoteRepositoryImpl(quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}