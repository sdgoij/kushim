package com.github.sdgoij.kushim

import org.junit.Assert.assertEquals
import org.junit.Test
import uniffi.kushim.artefactHashes

/**
 * The sample invoice must render to the same bytes on the device as on the host.
 *
 * The values are the ones `artefact_hashes_match_the_golden_values` asserts in
 * `crates/ffi/src/lib.rs`, and `just mobile-golden` runs both, so a change that
 * drifts on either side fails here or there.
 */
class ArtefactDeterminismTest {
    @Test
    fun the_sample_invoice_matches_the_host() {
        val hashes = artefactHashes()

        // The renderer identity is written into the UBL and into the PDF metadata,
        // so the name change moved both artefacts; these are the host values.
        assertEquals("UBL length", 4309UL, hashes.ublLen)
        assertEquals("PDF length", 15936UL, hashes.pdfLen)
        assertEquals(
            "UBL SHA-256",
            "a0e8eab64ed7ba9862d6a928c3f70dbd2c010dc0f3df362ac084124e654c352e",
            hashes.ublSha256,
        )
        assertEquals(
            "PDF SHA-256",
            "15351eadfc2f945eaa501ff48a474735d196ac4e4aa08171618ade9120615331",
            hashes.pdfSha256,
        )
    }

    @Test
    fun a_second_render_agrees_with_the_first() {
        val first = artefactHashes()
        val second = artefactHashes()

        assertEquals(first.ublSha256, second.ublSha256)
        assertEquals(first.pdfSha256, second.pdfSha256)
        assertEquals(first.ublLen, second.ublLen)
        assertEquals(first.pdfLen, second.pdfLen)
    }
}
