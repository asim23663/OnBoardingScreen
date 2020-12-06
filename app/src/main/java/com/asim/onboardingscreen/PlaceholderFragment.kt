package com.asim.onboardingscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.asim.onboardingscreen.databinding.FragmentPlaceholderBinding


class PlaceholderFragment : Fragment() {
    private var _binding: FragmentPlaceholderBinding? = null
    private val binding get() = _binding!!
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private val ARG_SECTION_NUMBER = "section_number"
    var img: ImageView? = null

    private val onBoardImages = intArrayOf(R.raw.on_board_1, R.raw.on_board_2, R.raw.on_board_3)

    private val onBoardTitle = arrayOf("Find A Donor", "Emergency Mode", "Be A Blood Donor")
    private val onBoardTitleSub = arrayOf("Find Blood Donors & Request For Blood","Emergency Mode Is There For You", "Become A Blood Donor & Save Lives")
    private val onBoardImageSub = arrayOf("Users will be able to create a donor account and will be able to save lives.", "In case of emergency, users will be able to get contact numbers of public account of donors.", "Users will be able to create a donor account and will be able to save lives.")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlaceholderBinding.inflate(inflater, container, false)
        val rootView = binding.root


        binding.placeHolderTvTitle.text = onBoardTitle[arguments!!.getInt(ARG_SECTION_NUMBER) - 1]
        binding.placeHolderTvTitleSub.text = onBoardTitleSub[arguments!!.getInt(ARG_SECTION_NUMBER) - 1]
        binding.placeHolderLottieAnim.setAnimation(onBoardImages[arguments!!.getInt(ARG_SECTION_NUMBER) - 1])
        binding.placeHolderTvImgSub.text = onBoardImageSub[arguments!!.getInt(ARG_SECTION_NUMBER) - 1]

        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(sectionNumber: Int) =
            PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}