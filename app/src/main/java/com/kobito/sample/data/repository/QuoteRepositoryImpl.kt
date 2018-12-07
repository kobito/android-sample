package com.kobito.sample.data.repository

import androidx.lifecycle.LiveData
import com.kobito.sample.data.db.QuoteDao
import com.kobito.sample.data.model.Quote

class QuoteRepositoryImpl(private val quoteDao: QuoteDao) : QuoteRepository {
    override fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    override fun getQuotes(): LiveData<List<Quote>> = quoteDao.getQuotes()
}