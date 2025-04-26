package com.vharya.tugas2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val pointWarrior = 12000
    private val pointArcher = 13000
    private val pointMage = 10000

    private val pointChampion = 5000
    private val pointPaladin = 7000
    private val pointHunter = 4000
    private val pointSniper = 6000
    private val pointWizard = 3500
    private val pointSorcerer = 5000

    private val pointAttack = 10000
    private val pointDefense = 8000
    private val pointASPD = 5000
    private val pointHP = 12000

    private var selectedHero = "warrior"
    private var selectedClass = "champion"
    private var selectedItem = "attack"
    private var totalBattlePower = pointWarrior + pointChampion + pointAttack

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputName = findViewById<EditText>(R.id.input_name)

        val radioGroupHero = findViewById<RadioGroup>(R.id.radio_group_hero)
        val radioGroupWarriorClass = findViewById<RadioGroup>(R.id.radio_group_warrior_class)
        val radioGroupArcherClass = findViewById<RadioGroup>(R.id.radio_group_archer_class)
        val radioGroupMageClass = findViewById<RadioGroup>(R.id.radio_group_mage_class)
        val radioGroupItem = findViewById<RadioGroup>(R.id.radio_group_item)

        val buttonSubmit = findViewById<Button>(R.id.submit_button)

        val characterImage = findViewById<ImageView>(R.id.character_image)
        val resultName = findViewById<TextView>(R.id.result_name)
        val resultHero = findViewById<TextView>(R.id.result_hero)
        val resultClass = findViewById<TextView>(R.id.result_class)
        val resultItem = findViewById<TextView>(R.id.result_item)
        val resultBattlePower = findViewById<TextView>(R.id.result_battle_point)

        radioGroupHero.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_warrior -> {
                    selectedHero = "warrior"
                    selectedClass = "champion"
                    totalBattlePower = pointWarrior

                    radioGroupWarriorClass.check(R.id.radio_champion)

                    radioGroupWarriorClass.visibility = View.VISIBLE
                    radioGroupArcherClass.visibility = View.GONE
                    radioGroupMageClass.visibility = View.GONE
                }
                R.id.radio_archer -> {
                    selectedHero = "archer"
                    selectedClass = "hunter"
                    totalBattlePower = pointArcher

                    radioGroupArcherClass.check(R.id.radio_hunter)

                    radioGroupWarriorClass.visibility = View.GONE
                    radioGroupArcherClass.visibility = View.VISIBLE
                    radioGroupMageClass.visibility = View.GONE
                }
                R.id.radio_mage -> {
                    selectedHero = "mage"
                    selectedClass = "wizard"
                    totalBattlePower = pointMage

                    radioGroupMageClass.check(R.id.radio_wizard)

                    radioGroupWarriorClass.visibility = View.GONE
                    radioGroupArcherClass.visibility = View.GONE
                    radioGroupMageClass.visibility = View.VISIBLE
                }
            }
        }

        radioGroupWarriorClass.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_champion -> {
                    selectedClass = "champion"
                    totalBattlePower += pointChampion
                }
                R.id.radio_paladin -> {
                    selectedClass = "paladin"
                    totalBattlePower += pointPaladin
                }
            }
        }

        radioGroupArcherClass.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_hunter -> {
                    selectedClass = "hunter"
                    totalBattlePower += pointHunter
                }
                R.id.radio_sniper -> {
                    selectedClass = "sniper"
                    totalBattlePower += pointSniper
                }
            }
        }

        radioGroupMageClass.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_wizard -> {
                    selectedClass = "wizard"
                    totalBattlePower += pointWizard
                }
                R.id.radio_sorcerer -> {
                    selectedClass = "sorcerer"
                    totalBattlePower += pointSorcerer
                }
            }
        }

        radioGroupItem.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_attack -> {
                    selectedItem = "attack"
                    totalBattlePower += pointAttack
                }
                R.id.radio_defense -> {
                    selectedItem = "defense"
                    totalBattlePower += pointDefense
                }
                R.id.radio_aspd -> {
                    selectedItem = "aspd"
                    totalBattlePower += pointASPD
                }
                R.id.radio_hp -> {
                    selectedItem = "hp"
                    totalBattlePower += pointHP
                }
            }
        }

        buttonSubmit.setOnClickListener {
            if (inputName.text.isNotBlank()) {
                resultName.text = inputName.text
            }

            when (selectedHero) {
                "warrior" -> resultHero.text = "Warrior (+$pointWarrior)"
                "archer" -> resultHero.text = "Archer (+$pointArcher)"
                "mage" -> resultHero.text = "Mage (+$pointMage)"
            }

            when (selectedClass) {
                "champion" -> {
                    resultClass.text = "Champion (+$pointChampion)"
                    characterImage.setImageResource(R.drawable.img_champion)
                }
                "paladin" -> {
                    resultClass.text = "Paladin (+$pointPaladin)"
                    characterImage.setImageResource(R.drawable.img_paladin)
                }
                "hunter" -> {
                    resultClass.text = "Hunter (+$pointHunter)"
                    characterImage.setImageResource(R.drawable.img_hunter)
                }
                "sniper" -> {
                    resultClass.text = "Sniper (+$pointSniper)"
                    characterImage.setImageResource(R.drawable.img_sniper)
                }
                "wizard" -> {
                    resultClass.text = "Wizard (+$pointWizard)"
                    characterImage.setImageResource(R.drawable.img_wizard)
                }
                "sorcerer" -> {
                    resultClass.text = "Sorcerer (+$pointSorcerer)"
                    characterImage.setImageResource(R.drawable.img_sorcerer)
                }
            }

            when (selectedItem) {
                "attack" -> resultItem.text = "Attack (+$pointAttack)"
                "defense" -> resultItem.text = "Defense (+$pointDefense)"
                "aspd" -> resultItem.text = "ASPD (+$pointASPD)"
                "hp" -> resultItem.text = "HP (+$pointHP)"
            }

            resultBattlePower.text = totalBattlePower.toString()
        }
    }
}