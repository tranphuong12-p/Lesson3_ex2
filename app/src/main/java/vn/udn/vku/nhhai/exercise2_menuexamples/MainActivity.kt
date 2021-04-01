package vn.udn.vku.nhhai.exercise2_menuexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    lateinit var fbBar:SeekBar
    lateinit var igBar:SeekBar
    lateinit var twBar:SeekBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fbBar = findViewById<SeekBar>(R.id.fbSeekbar)
        igBar = findViewById<SeekBar>(R.id.igSeekbar)
        twBar = findViewById<SeekBar>(R.id.twSeekbar)
        fbBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val fbTextView = findViewById<TextView>(R.id.fbTextView)
                fbTextView.text = progress.toString() + "%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        igBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val igTextView = findViewById<TextView>(R.id.igTextView)
                igTextView.text = progress.toString() + "%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        twBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val twTextView = findViewById<TextView>(R.id.twTextView)
                twTextView.text = progress.toString() + "%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        val fullButton = findViewById<ImageButton>(R.id.fullBtn)
        val clearButton = findViewById<ImageButton>(R.id.clearBtn)
        fullButton.setOnClickListener {
            fbBar.progress = 100
            igBar.progress = 100
            twBar.progress = 100
        }
        clearButton.setOnClickListener{
            fbBar.progress = 0
            igBar.progress = 0
            twBar.progress = 0
        }

        val menuButton = findViewById<Button>(R.id.popupButton)
        registerForContextMenu(menuButton)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.option_full_item -> {
                fbBar.progress = 100
                igBar.progress = 100
                twBar.progress = 100
            }
            R.id.option_half_item -> {
                fbBar.progress = 50
                igBar.progress = 50
                twBar.progress = 50
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.popup_menu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val fullButton = findViewById<ImageButton>(R.id.fullBtn)
        val clearButton = findViewById<ImageButton>(R.id.clearBtn)
        when(item.itemId){
            R.id.popup_saybye_item ->{
                Toast.makeText(this,"Goodbye class",
                Toast.LENGTH_LONG).show()
            }
            R.id.popup_hide_item -> {
                fullButton.isVisible = false
                clearButton.isVisible = false
            }
            R.id.popup_show_item -> {
                fullButton.isVisible = true
                clearButton.isVisible = true
            }
        }
        return super.onContextItemSelected(item)
    }
}