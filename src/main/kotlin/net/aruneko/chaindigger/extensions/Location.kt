package net.aruneko.chaindigger.extensions

import org.bukkit.Location
import kotlin.math.abs

fun Location.manhattanDistance(another: Location): Int {
    val x = abs(this.blockX - another.blockX)
    val y = abs(this.blockY - another.blockY)
    val z = abs(this.blockZ - another.blockZ)

    return x + y + z
}
