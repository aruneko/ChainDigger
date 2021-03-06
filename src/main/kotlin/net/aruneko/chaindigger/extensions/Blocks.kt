package net.aruneko.chaindigger.extensions

import org.bukkit.block.Block

fun List<Block>.extractEquals(block: Block) : List<Block> {
    return this.filter { it.type === block.type }
}
