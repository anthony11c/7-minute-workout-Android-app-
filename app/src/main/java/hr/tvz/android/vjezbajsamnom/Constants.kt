package hr.tvz.android.vjezbajsamnom

class Constants {
    companion object {

        // The drawable images used here are added in the drawable folder.
        /**
         * Here we are adding all exercises to a single list with all the default values.
         */
        fun defaultExerciseList(): ArrayList<ExerciseModel> {

            val exerciseList = ArrayList<ExerciseModel>()

            val jumpingJacks =
                ExerciseModel(1, "Jumping Jacks", R.raw.jumpingjacks, false, false)
            exerciseList.add(jumpingJacks)

            val wallSit = ExerciseModel(2, "Wall Sit", R.raw.wallsit, false, false)
            exerciseList.add(wallSit)

            val pushUp = ExerciseModel(3, "Push Up", R.raw.pushups, false, false)
            exerciseList.add(pushUp)

            val abdominalCrunch =
                ExerciseModel(4, "Abdominal Crunch", R.raw.abdominalcrunches, false, false)
            exerciseList.add(abdominalCrunch)

            val stepUpOnChair =
                ExerciseModel(
                    5,
                    "Step-Up onto Chair",
                    R.raw.stepups,
                    false,
                    false
                )
            exerciseList.add(stepUpOnChair)

            val squat = ExerciseModel(6, "Squat", R.raw.squats, false, false)
            exerciseList.add(squat)

            val tricepDipOnChair =
                ExerciseModel(
                    7,
                    "Tricep Dip On Chair",
                    R.raw.tricepdips,
                    false,
                    false
                )
            exerciseList.add(tricepDipOnChair)

            val plank = ExerciseModel(8, "Plank", R.raw.plank, false, false)
            exerciseList.add(plank)

            val highKneesRunningInPlace =
                ExerciseModel(
                    9, "High Knees Running In Place",
                    R.raw.highknees,
                    false,
                    false
                )
            exerciseList.add(highKneesRunningInPlace)

            val lunges = ExerciseModel(10, "Lunges", R.raw.lunges, false, false)
            exerciseList.add(lunges)

            val pushupAndRotation =
                ExerciseModel(
                    11,
                    "Push up and Rotation",
                    R.drawable.ic_push_up_and_rotation,
                    false,
                    false
                )
            exerciseList.add(pushupAndRotation)

            val sidePlank = ExerciseModel(12, "Side Plank", R.raw.sideplank, false, false)
            exerciseList.add(sidePlank)

            return exerciseList
        }
    }
}