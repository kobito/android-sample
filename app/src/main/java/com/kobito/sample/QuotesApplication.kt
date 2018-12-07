package com.kobito.sample

import android.app.Application
import com.kobito.sample.data.db.Database
import com.kobito.sample.data.db.DatabaseFakeImpl
import com.kobito.sample.data.db.QuoteDao
import com.kobito.sample.data.repository.QuoteRepository
import com.kobito.sample.data.repository.QuoteRepositoryImpl
import com.kobito.sample.ui.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class QuotesApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        bind<Database>() with singleton { DatabaseFakeImpl() }
        bind<QuoteDao>() with singleton { instance<Database>().quoteDao }
        bind<QuoteRepository>() with singleton { QuoteRepositoryImpl(instance()) }
        bind() from provider { QuotesViewModelFactory((instance())) }
    }

}