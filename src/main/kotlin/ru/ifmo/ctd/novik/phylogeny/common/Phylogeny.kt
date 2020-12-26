package ru.ifmo.ctd.novik.phylogeny.common

import ru.ifmo.ctd.novik.phylogeny.network.Branch
import ru.ifmo.ctd.novik.phylogeny.utils.unify

data class Phylogeny(val cluster: Cluster, val branches: List<Branch>) {
    fun unify() {
        cluster.unify()
    }
}