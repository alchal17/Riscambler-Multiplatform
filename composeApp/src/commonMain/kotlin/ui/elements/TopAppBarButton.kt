package ui.elements

data class TopAppBarButton(val buttonText: String, val suboptions: List<Pair<String, () -> Unit>>)