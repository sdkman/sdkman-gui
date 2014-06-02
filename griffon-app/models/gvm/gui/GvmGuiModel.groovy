package gvm.gui

import ca.odell.glazedlists.BasicEventList
import ca.odell.glazedlists.EventList
import net.gvmtool.client.Candidate
import net.gvmtool.client.Version

class GvmGuiModel {
    @Bindable
    Candidate selectedCandidate
    EventList<Candidate> candidates = new BasicEventList<>()

    @Bindable
    Version selectedVersion
    EventList<Version> versions = new BasicEventList<>()
}