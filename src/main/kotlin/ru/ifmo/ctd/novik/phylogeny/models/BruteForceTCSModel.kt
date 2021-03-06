package ru.ifmo.ctd.novik.phylogeny.models

import ru.ifmo.ctd.novik.phylogeny.network.Cluster
import ru.ifmo.ctd.novik.phylogeny.distance.cluster.ClusterDistanceEvaluator
import ru.ifmo.ctd.novik.phylogeny.network.merging.BruteForceMergingCandidate
import ru.ifmo.ctd.novik.phylogeny.network.merging.MergingCandidate

/**
 * @author Dmitry Novik ITMO University
 */
class BruteForceTCSModel(distanceEvaluator: ClusterDistanceEvaluator) : TCSModel(distanceEvaluator) {
    override fun createMergingCandidate(first: Cluster, second: Cluster, genomNumber: Int): MergingCandidate {
        val distance = evaluate(first, second)
        return BruteForceMergingCandidate(first, second, taxonDistanceEvaluator, distance)
    }
}