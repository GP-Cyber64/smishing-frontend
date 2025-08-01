package com.example.smishingdetectionapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;


import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.example.smishingdetectionapp.Community.CommunityReportActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;


public class HelpActivity extends SharedActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_updated);
        BottomNavigationView nav = findViewById(R.id.bottom_navigation);

        nav.setSelectedItemId(R.id.nav_settings);

        nav.setOnItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();
            if (id == R.id.nav_home) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                overridePendingTransition(0, 0);
                finish();
                return true;

            } else if (menuItem.getItemId() == R.id.nav_report) {
                Intent i = new Intent(this, CommunityReportActivity.class);
                i.putExtra("source", "home");
                startActivity(i);
                overridePendingTransition(0,0);
                finish();
                return true;

            } else if (id == R.id.nav_news) {
                startActivity(new Intent(getApplicationContext(), NewsActivity.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_settings) {
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                intent.putExtra("from_navigation", true);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                return true;
            }
            return false;
        });


        // Adjust padding for system insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Back button: finish activity
        ImageButton helpBack = findViewById(R.id.help_back);
        helpBack.setOnClickListener(v -> {
            startActivity(new Intent(this, SettingsActivity.class));
            finish();
        });

        // Menu button: handle as needed
        ImageButton helpMenu = findViewById(R.id.help_menu);
        helpMenu.setOnClickListener(v -> {
            // Implement menu actions if necessary
        });


        // Common Topics Click Listeners
        MaterialCardView cardTopic1 = findViewById(R.id.cardTopic1);
        cardTopic1.setOnClickListener(v -> {
            Intent intent = new Intent(this, TopicDetailActivity.class);
            intent.putExtra("TOPIC_ID", "DETECT_SMISHING");
            startActivity(intent);
        });

        MaterialCardView cardTopic2 = findViewById(R.id.cardTopic2);
        cardTopic2.setOnClickListener(v -> {
            Intent intent = new Intent(this, TopicDetailActivity.class);
            intent.putExtra("TOPIC_ID", "REPORT_SMS");
            startActivity(intent);
        });

        MaterialCardView cardTopic3 = findViewById(R.id.cardTopic3);
        cardTopic3.setOnClickListener(v -> {
            Intent intent = new Intent(this, TopicDetailActivity.class);
            intent.putExtra("TOPIC_ID", "SMISHING_VS_PHISHING");
            startActivity(intent);
        });


        // FAQ Cards Click Listeners
        MaterialCardView cardFAQ2 = findViewById(R.id.cardFAQ2);
        if (cardFAQ2 != null) {
            cardFAQ2.setOnClickListener(v -> {
                Intent intent = new Intent(HelpActivity.this, FaqActivity.class);
                intent.putExtra("faq_topic", "adjust_settings");
                startActivity(intent);
            });
        }


        // Contact Options Click Listeners
        MaterialCardView cardCallUs = findViewById(R.id.cardCallUs);
        if (cardCallUs != null) {
            cardCallUs.setOnClickListener(v -> {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:+1234567890")); // Replace with your phone number
                startActivity(phoneIntent);
            });
        }
        MaterialCardView cardMailUs = findViewById(R.id.cardMailUs);
        if (cardMailUs != null) {
            cardMailUs.setOnClickListener(v -> {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:support@example.com")); // Replace with your email address
                startActivity(emailIntent);
            });
        }
        MaterialCardView cardFeedback = findViewById(R.id.cardFeedback);
        if (cardFeedback != null) {
            cardFeedback.setOnClickListener(v ->
                    startActivity(new Intent(HelpActivity.this, FeedbackActivity.class))
            );

        }
    }
}
