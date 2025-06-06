import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.MainViewModel
import com.example.myapplication.NavItems
import com.example.myapplication.pages.HomePage
import com.example.myapplication.pages.NotificationPage
import com.example.myapplication.pages.SettingPage
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    val navItemList = listOf(
        NavItems(label = "Home", icon = Icons.Default.Home),
        NavItems(label = "Notifications", icon = Icons.Default.Notifications),
        NavItems(label = "Settings", icon = Icons.Default.Settings),
        NavItems(label = "Toto List", icon = Icons.Default.Info),

        )
    val selectedIndex by viewModel.selectedIndex.collectAsState()
    val sheetState = rememberModalBottomSheetState()
    val showBottomSheet by viewModel.showBottomsheet.collectAsState()
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                viewModel.dismissBottomsheet()
            },
            sheetState = sheetState,

            ) {
            Text(text = "Bottom sheet Content")
        }
    }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(text = "Navigation Drawer", modifier = Modifier.padding(16.dp))
                VerticalDivider()
                Text(text = "Option 1", modifier = Modifier.padding(16.dp))
                Text(text = "Option 2", modifier = Modifier.padding(16.dp))
            }
        }
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "My App")
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch { drawerState.open() }
                            }
                        ) {
                            Icon(
                                Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFFC8C8D0),
                        titleContentColor = Color.Black,
                        navigationIconContentColor = Color.DarkGray,
                        actionIconContentColor = Color.DarkGray,
                        scrolledContainerColor = Color(0xFFB0B0C0)
                    )
                )
            },
            bottomBar = {
                NavigationBar {
                    navItemList.forEachIndexed { index, navItems ->
                        NavigationBarItem(
                            selected = selectedIndex == index,
                            onClick = {
                                viewModel.onNavItemClicked(index)
                            },
                            icon = {
                                Icon(imageVector = navItems.icon, contentDescription = "Icon")
                            },
                            label = {

                                Text(text = navItems.label)
                            },
                        )
                    }
                }
            },


            ) { innerPadding ->
            ContentScreen(
                modifier = modifier.padding(innerPadding), selectedIndex, viewModel = viewModel
            )
        }
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int, viewModel: MainViewModel) {
    when (selectedIndex) {
        0 -> HomePage(modifier = modifier)
        1 -> NotificationPage()
        2 -> SettingPage(viewModel = viewModel)
        3 -> TodoListScreen()
    }
}