package gvm.gui

import ca.odell.glazedlists.BasicEventList
import ca.odell.glazedlists.EventList
import net.gvmtool.client.Candidate

class GvmGuiModel {
    @Bindable Candidate selectedCandidate
    EventList<Candidate> candidates = new BasicEventList<>()
}