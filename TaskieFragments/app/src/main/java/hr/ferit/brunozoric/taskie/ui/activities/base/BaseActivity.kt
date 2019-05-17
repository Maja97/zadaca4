package hr.ferit.brunozoric.taskie.ui.activities.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import hr.ferit.brunozoric.taskie.R
import hr.ferit.brunozoric.taskie.common.showFragment
import hr.ferit.brunozoric.taskie.ui.fragments.PagerFragment
import hr.ferit.brunozoric.taskie.ui.fragments.TasksFragment
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutResourceId())
        setUpUi()
        setFragment()
    }

    private fun setFragment() {
         val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem->
            when(menuItem.itemId)
            {
                R.id.nav_tasks-> {val fragment= TasksFragment()
                    showFragment(R.id.fragmentContainer,fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_about-> {val fragment = PagerFragment()
                    showFragment(R.id.fragmentContainer,fragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    protected fun showFragment(fragment: Fragment){
        showFragment(R.id.fragmentContainer, fragment)
    }

    abstract fun getLayoutResourceId(): Int
    abstract fun setUpUi()
}