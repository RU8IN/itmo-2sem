package commands

import storage.HumanCollectionInterface
import utils.PrintTypesEnum
import utils.CommandAnnotation

@kotlinx.serialization.Serializable
@CommandAnnotation("sorted_by_descending_mood", "Prints collection sorted by descending mood","sbdm")
class SortedByDescendingMoodCommand() : SealedCommand() {

    override fun execute(collection: HumanCollectionInterface): List<Pair<PrintTypesEnum, String>> {
        if (collection.isEmpty()) return listOf(Pair(PrintTypesEnum.WARNING, "Collection is empty"))
        val elementsList = mutableListOf<Pair<PrintTypesEnum, String>>()
        collection.sortedByDescendingMood().forEach {
            elementsList.add(Pair(PrintTypesEnum.INFO, it.toString()))
        }
        return elementsList
    }
}