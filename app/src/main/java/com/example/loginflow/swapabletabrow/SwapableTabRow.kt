@file:OptIn(ExperimentalFoundationApi::class)

package com.example.loginflow.swapabletabrow

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

val tableItems = listOf(
    TableItem(
        title = "Home",
        unselectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home
    ),
    TableItem(
        title = "Browse",
        unselectedIcon = Icons.Outlined.ShoppingCart,
        selectedIcon = Icons.Filled.ShoppingCart
    ),
    TableItem(
        title = "Account",
        unselectedIcon = Icons.Outlined.AccountCircle,
        selectedIcon = Icons.Filled.AccountCircle
    )
)

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun SwapRows() {

    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        tableItems.size
    }
    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tableItems.forEachIndexed { index, item ->
                Tab(
                    selected = index == selectedTabIndex, onClick = {
                        selectedTabIndex = index
                    },
                    text = { Text(text = item.title) },
                    icon = {
                        Icon(
                            imageVector = if (index == selectedTabIndex) {
                                item.selectedIcon
                            } else {
                                item.unselectedIcon
                            },
                            contentDescription = item.title
                        )
                    }
                )
            }

        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = tableItems[index].title)
            }


        }

    }

}


data class TableItem(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector
)