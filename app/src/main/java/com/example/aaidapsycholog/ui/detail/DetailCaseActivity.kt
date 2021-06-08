package com.example.aaidapsycholog.ui.detail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.aaidapsycholog.R
import com.example.aaidapsycholog.data.response.UserCaseResponseItem
import com.example.aaidapsycholog.data.response.UserDetailCaseResponse
import com.example.aaidapsycholog.databinding.ActivityDetailCaseBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailCaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailCaseBinding

    companion object{
        const val EXTRA_CASE = "extra_case"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailCaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showCaseDetail()

    }

    private fun populateCase(case: UserCaseResponseItem){
        with(binding){
            tvLabel.text = case.jsonMemberClass
            tvScore.text = case.score.toString()
            tvFlw.text = case.followers.toString()
            tvFlwrs.text = case.following.toString()
            tvName.text = case.name
            tvTwit.text = case.tweet
            tvUsername.text = case.screenName

            btnDm.setOnClickListener{
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/messages/compose?recipient_id=${case.twitterUserId}&text="))
                startActivity(intent)
            }
        }
    }

    private fun showCaseDetail(){
        val extras = intent.extras
        if (extras != null){
            val case = extras.getParcelable<UserCaseResponseItem>(EXTRA_CASE)
            if (case != null) {
                populateCase(case)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean{
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}