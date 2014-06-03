package gvm.gui

import net.gvmtool.client.Candidate
import net.gvmtool.client.GvmClient
import net.gvmtool.client.Version

import java.awt.event.ActionEvent

class GvmGuiController {
    // these will be injected by Griffon
    def model
    def view

    def gvmClient = GvmClient.instance()

    void mvcGroupInit(Map args) {
        model.addPropertyChangeListener('selectedCandidate', {evt -> refreshVersions()})
    }

    def refreshCandidates(ActionEvent evt = null) {
        List<Candidate> candidates = GvmClient.instance().candidates

        log.info("Refreshed Candidates")
        log.debug("${candidates*.name}")

        execInsideUIAsync {
            model.candidates.clear()
            model.candidates.addAll(candidates)
        }
    }

    def refreshVersions(ActionEvent evt = null) {
        execInsideUISync {
            model.versions.clear()
        }

        if (!model.selectedCandidate) return

        def selectedCandidate = model.selectedCandidate
        List<Version> versions = gvmClient.getVersionsFor(selectedCandidate.name)

        versions.sort({a,b -> b.name <=> a.name})

        log.info("Refreshed versions for candidate $selectedCandidate")
        log.debug("${versions*.name}")

        execInsideUIAsync {
            model.versions.addAll(versions)
        }
    }

    def quitAction = {ActionEvent evt = null ->
        ApplicationHolder.getApplication().shutdown();
    }

    def aboutAction = {ActionEvent evt = null ->
        println("About")
    }
}
