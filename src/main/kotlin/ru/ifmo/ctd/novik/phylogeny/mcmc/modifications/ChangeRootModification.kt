package ru.ifmo.ctd.novik.phylogeny.mcmc.modifications

import ru.ifmo.ctd.novik.phylogeny.tree.RootedTopology
import ru.ifmo.ctd.novik.phylogeny.utils.GlobalRandom
import ru.ifmo.ctd.novik.phylogeny.utils.mergeTwoEdges

class ChangeRootModification : Modification {
    override fun invoke(topology: RootedTopology): RootedTopology {
        val recombinationEdges = topology.recombinationEdges

        val oldRoot = topology.root
        val edgeWithNewRoot = oldRoot.edges.filter { it !in recombinationEdges }.random(GlobalRandom)
        val newRoot = topology.getOrCreateNode(edgeWithNewRoot.nodes[1])

        val edgeBetweenRoots = newRoot.edges.first { it.end === oldRoot }
        newRoot.next.add(edgeBetweenRoots)
        oldRoot.next.removeIf { it.end === newRoot }
        topology.mergeTwoEdges(oldRoot)

        return topology.copy(root = newRoot)
    }
}