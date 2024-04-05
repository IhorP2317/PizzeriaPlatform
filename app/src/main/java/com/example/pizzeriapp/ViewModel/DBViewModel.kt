package com.example.pizzeriapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzeriapp.Database.GoodItem
import com.example.pizzeriapp.Database.GoodItemsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class DBViewModel(private val itemRepository: GoodItemsRepository) : ViewModel() {

    fun insert(item: GoodItem) = viewModelScope.launch {

        itemRepository.insert(item)
    }
    fun getAllSpendingItems() : Flow<List<GoodItem>> {
        return itemRepository.getAllItems()
    }
}
