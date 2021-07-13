package com.example.tester49
//category model

class CategoryModel {
    private var selected = false
    private var title: String? = null

    fun isSelected(): Boolean {
        return selected
    }

    fun setSelected(selected: Boolean) {
        this.selected = selected
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }
}