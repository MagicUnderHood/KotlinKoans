import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

enum class TimeInterval { DAY, WEEK, YEAR }
data class TimesInterval(val interval: TimeInterval, val times: Int)

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = this.addTimeIntervals(timeInterval, 1)
operator fun MyDate.plus(timesInterval: TimesInterval): MyDate =
    this.addTimeIntervals(timesInterval.interval, timesInterval.times)

operator fun TimeInterval.times(times: Int): TimesInterval = TimesInterval(this, times)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}

fun main(args: Array<String>) {
    val today = MyDate(2020, 7, 10)
    println(task1(today) == MyDate(2021, 7, 17))
    println(task2(today) == MyDate(2022, 8, 5))
}