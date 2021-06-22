package ir.rahcode.motionlayout_playground3

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import ir.rahcode.motionlayout_playground3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var CARD_TOP = 65


    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding!!.root)


        setupViews()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupViews() {



        binding.motionChooseModeActivityMainMotion.setOnTouchListener(
            object :
                OnSwipeTouchListener(this.application) {
                override fun onSwipeTop() {}

                override fun onSwipeRight() {
                    var cardTop = CARD_TOP%4
                    when (cardTop) {
                        1 -> {
                            binding.motionChooseModeActivityMainMotion.setTransition(R.id.tran_chooseModeActivity_card2top)
                            binding.motionChooseModeActivityMainMotion.transitionToEnd()
                        }
                        2 -> {
                            binding.motionChooseModeActivityMainMotion.setTransition(R.id.tran_chooseModeActivity_card3Top)
                            binding.motionChooseModeActivityMainMotion.transitionToEnd()
                        }
                        3->{
                            binding.motionChooseModeActivityMainMotion.setTransition(R.id.tran_chooseModeActvitiy_card4Top)
                            binding.motionChooseModeActivityMainMotion.transitionToEnd()
                        }
                        0->{
                            binding.motionChooseModeActivityMainMotion.setTransition(R.id.tran_chooseModeActivity_card1Top)
                            binding.motionChooseModeActivityMainMotion.transitionToEnd()
                        }
                    }
                    CARD_TOP++

                    Toast.makeText(this@MainActivity,"forward ${CARD_TOP%4}" , Toast.LENGTH_SHORT).show()
                }

                override fun onSwipeLeft() {
                    var cardTop = CARD_TOP%4
                    when (cardTop) {
                        1 -> {
                            binding.motionChooseModeActivityMainMotion.setTransition(R.id.tran_chooseMode_card4Top_backward)
                            binding.motionChooseModeActivityMainMotion.transitionToEnd()
                        }
                        2 -> {
                            binding.motionChooseModeActivityMainMotion.setTransition(R.id.tran_chooseModeActivity_card1Top_backward)
                            binding.motionChooseModeActivityMainMotion.transitionToEnd()
                        }
                        3->{
                            binding.motionChooseModeActivityMainMotion.setTransition(R.id.tran_chooseModeActivity_card2Top_backward)
                            binding.motionChooseModeActivityMainMotion.transitionToEnd()
                        }
                        0->{
                            binding.motionChooseModeActivityMainMotion.setTransition(R.id.tran_chooseModeActivity_card3Top_backward)
                            binding.motionChooseModeActivityMainMotion.transitionToEnd()
                        }
                    }
                    CARD_TOP--

                    Toast.makeText(this@MainActivity," backward ${CARD_TOP%4}" , Toast.LENGTH_SHORT).show()
                }

                override fun onSwipeBottom() {}
            })

        binding.motionChooseModeActivityMainMotion.addTransitionListener(object : MotionLayout.TransitionListener{
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                disableViews()
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                enableViews()
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }
        })

    }

    private fun enableViews() {

        binding.motionChooseModeActivityMainMotion.isEnabled = true
        binding.relGameModeActivityRel1.isEnabled = true
        binding.relGameModeActivityRel2.isEnabled = true
        binding.relGameModeActivityRel3.isEnabled = true
        binding.relGameModeActivityRel4.isEnabled = true
    }

    private fun disableViews() {

        binding.motionChooseModeActivityMainMotion.isEnabled = false
        binding.relGameModeActivityRel1.isEnabled = false
        binding.relGameModeActivityRel2.isEnabled = false
        binding.relGameModeActivityRel3.isEnabled = false
        binding.relGameModeActivityRel4.isEnabled = false
    }

}