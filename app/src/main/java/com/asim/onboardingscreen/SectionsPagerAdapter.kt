package com.asim.onboardingscreen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.asim.onboardingscreen.PlaceholderFragment.Companion.newInstance

class SectionsPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return newInstance(position + 1)
    }

    override fun getCount(): Int {
        // Show 3 total pages.
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "SECTION 1"
            1 -> return "SECTION 2"
            2 -> return "SECTION 3"
        }
        return null
    }
}