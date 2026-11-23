# ADR-026: The product is named Kushim, the earliest bookkeeper known by name

**Status:** Accepted, 2026-11-23

## Context

`bonk` was a working name, and nothing in the architecture depends on it: no
column, no wire format and no on-disk contract carries the word. The binary
name, the `BONK_` environment prefix, the default archive `bonk.db`, the window
title, the credential-store entry and the Android `applicationId` do. All of them
are mechanical except the last, which is permanent once a release ships, and that
sets the deadline for this decision rather than any technical constraint.

The name has to serve a local-first e-invoicing and bookkeeping client sold to
Dutch small businesses whose pitch is provable custody of compliant documents.
It has to read correctly in Dutch and English, survive being said aloud in a
support call, not collide with the Dutch accounting incumbents, and carry no slur
or hostile meaning in the market it is sold in. `bonk` fails the last test in
British English, where it is a vulgarism, and it says nothing about invoices,
ledgers or trust in any language.

## Decision

**Kushim** (Sumerian 𒆪𒋆, KU.ŠIM; fl. c. 3200 BC) — the transliteration as it
appears in the editions and catalogue entries, not a variant of it.

Kushim is potentially the earliest recorded personal name in writing, and it
appears on Uruk-period clay tablets that record barley and beer transactions:
quantities charged to named officials on the obverse, and the total credited to
Kushim on the reverse, "properly discharged" — a control total and a
reconciliation some 4,700 years before Pacioli. The sources are Nissen, Damerow
and Englund, *Archaic Bookkeeping* (Chicago, 1993), p. 36; the tablet MS 1717;
and MSVO 3, 29 in the CDLI catalogue. Reading the reverse as Kushim's own
account is an interpretation, not a certainty.

Three properties of that record make it the right origin for this product.

- The earliest writing that survives is administrative — goods, rations and
  liabilities — not literature.
- The oldest name in that corpus is a signature on an account.
- The material makes the argument. Clay is inert: the tablets are legible
  because the medium needs no publisher, no account and no migration, and once
  baked a tablet cannot be amended, so a correction is a new record. That is an
  analogy rather than a claim: it is what this product is trying to be, not a
  fact about how scribes worked.

The claim is stated as *the earliest bookkeeper whose name survives*, not "the
first accountant" (accounting predates writing by millennia) and not "the first
named person" (Iry-Hor, predynastic Egyptian, is the usual candidate for that).
The gloss has precedent in the accounting press: Badenhorst, "Meet Kushim, the
accountant from ancient Sumer", AccountingWeb, 2015.
It is hedged on identity, because it is unresolved whether KU.ŠIM is a person,
an office title or an institution.

**On spelling.** KU.ŠIM is transliterated `Kushim`, and in running text the
ending can be rendered `-eem`, giving `Kusheem`. That rendering is not an
invention: it is how the Hebrew *Kushim* is pronounced. The Hebrew word is the
plural of *Kushi*, a term for a dark-skinned person of African descent that is
used as a slur, and that is the objection the project owner raised. The objection
attaches to the sound, not to the letters.

Read as English, `Kushim` is "KUSH-im" and does not land on that word. Read as
`Kusheem`, it is "ku-SHEEM" and does. A variant that reproduces the pronunciation
of an offensive word is not a way of evading the association; it is a way of
delivering the reader to it.

Choosing the transliteration costs something in Dutch, where `Kushim` reads as
"kus him" — "kiss him". That is recorded as an accepted cost rather than an
oversight: the criterion above is that the name carry no slur, not that it carry
no wordplay, and a homophone in one market was judged survivable where a slur was
not.

An earlier draft of this record claimed the opposite — that `Kusheem` avoided the
homograph. That was backwards, and the mistake is kept in view: the string was
screened and the sound was not.

The rule this produces:

> Screen a name for how it is heard, not only for how it is spelled. A name is
> heard before it is understood, and a spelling that leaves the sound intact
> leaves the association intact.

**Identifiers.** Binary `kushim`; environment variables `KUSHIM_*`; default
archive `kushim.db`; data directory `Kushim`; window title and credential-store
entry `Kushim`, credential-store entry `kushim`; Android `applicationId` `com.github.sdgoij.kushim`; FFI library
`kushim`. The UniFFI namespace that the Kotlin bindings import is declared in
the scaffolding rather than derived here, so the rename has to check it rather
than assume it follows the library name.

**No alias.** The `bonk.db` fallback that an earlier draft of this record promised
is dropped. Nothing has shipped, so there is no archive in the field to keep
readable, and a compatibility path for a name that never reached a user is state
that has to be maintained and eventually removed. The rename is a clean break.

## Consequences

- `Kushim` is read as "KUSH-im" in English. In Dutch it reads as "kus him", the
  accepted cost above, and nobody is coached to say "ku-SHEEM", which is the word
  the owner objected to.
- The written form is also a Hebrew word. The Sumerian name is unrelated —
  Sumerian is a language isolate — so the collision is an artefact of Latin
  transliteration rather than a borrowing. The owner accepted the residual
  exposure rather than wait for a clearance nobody could give.
- The `applicationId` is the only irreversible identifier. It has to be final
  before the first Play upload and is cheap until then.
- Every public sentence keeps the hedge. "The earliest bookkeeper whose name
  survives" is defensible; "the inventor of accounting" is not.
- The name needs one sentence of explanation to most readers. That sentence is
  also the brand: a signature on the oldest account we can read.
- The rename touches roughly 127 tracked files: the CLI binary, `KUSHIM_*`, the
  default paths, `KushimApp`, the fixtures that reference `kushim.db`, the
  `Justfile`, `.githooks`, `ci.yml` and its artefact names, `README.md`, the
  Android package and Gradle namespaces, and the `tools/` scripts.
- Every document in the repository uses the name, including the design notes,
  spikes and ADRs dated before this decision. They were rewritten rather than
  left with the working name, because nothing has shipped and a mixed vocabulary
  invites mistakes. The cost is that the record no longer shows what the product
  was called while those decisions were made, and this ADR is where that is
  recorded.

## What the exercise produced beyond the name

The historical research produced a rule worth keeping after the name is
forgotten, because it is the same discipline the product sells:

> A claim enters a design note or a marketing page only with a source that
> survives a click — a page in a publication, or a catalogue record with an
> identification number. Summaries, blog headlines and search overviews do not
> qualify, however confidently phrased.

Applied to Kushim, that rule removed one claim that circulates widely. The
arithmetic-error story does not survive contact with a source: the specific
figures repeated online — entries totalling 3,910 bowls against a recorded 3,895
— name no tablet. The claim traces to a popular-mathematics video on the first
known maths mistake, which the Kushim article itself lists as further viewing;
that is a summary rather than an edition, and its content could not be verified
for this record. The one discrepancy that is documented is the tablet's total,
quoted as 29,086 measures where recalculation of the signs gives 28,086, and the
published note attributes that to a *transcription* error in modern secondary
sources rather than to a scribe.

The transcription error is the better story anyway, and it belongs to our
century: the most-quoted number from the first accounting record in history is
wrong because someone retyped it. That is still available as an argument for
deterministic output.

| Claim | Status |
|-------|--------|
| Kushim is potentially the earliest recorded personal name | Supported, hedged |
| It is uncertain whether KU.ŠIM is a person, a title or an institution | Supported |
| The records are Uruk-period clay tablets, barley and beer accounts | Supported |
| Obverse charges, reverse credit, "properly discharged" | Supported, reading contested |
| Kushim made arithmetic errors | **Not asserted** |
| Kushim's tablets show embezzlement | **Not asserted** |
| The tablets are double-entry | **Not asserted** |

## Alternatives

Availability was checked only informally: crates.io names, and domains for the
candidates that got that far. No trademark search in classes 9 or 42 has been
done for any name in this record.

- **`bonk` (keep the working name).** No migration cost at all. Rejected: a
  vulgarism in the language of the standard the product implements, a weak mark,
  and a name that tells a buyer nothing.
- **`Kusheem` (the phonetic transliteration of the chosen name).** Rejected: it
  is the pronunciation of the Hebrew *Kushim*, the plural of *Kushi*, and so
  delivers the reader to the word the project owner objected to, where `Kushim`
  read as English does not. See the spelling note above.
- **Kubera.** Lord of wealth and guardian of buried treasure, the best myth of
  the classical set. Rejected on availability: `kubera.com` is an established
  personal-finance product, and Kubra is a large billing and payments company
  with a near-identical pronunciation. A Dutch SME cannot decode the reference
  either.
- **Nemesis.** Offered and rejected immediately. She is the agent of retribution
  against hubris, not of balance; in modern English the word means archenemy. The
  register is wrong for a compliance tool and the name is unsearchable against a
  dictionary entry, a Resident Evil title and a Star Trek film.
- **Vesta.** The Vestals were the custodians of the state's wills and treaties,
  the closest classical fit to document custody. The strongest alternative.
  Rejected for legibility: the myth has to be explained, where a bookkeeper does
  not.
- **Arca.** Latin for strongbox; four letters and no baggage. Rejected as a
  container rather than a practice.
- **Fasti.** The Roman state's inscribed register of public acts — "the official
  record". Rejected as a calendar word before it is a record: it names days and
  magistrates rather than money, and it carries no meaning to a Dutch buyer.
- **Fides.** Good faith and oaths, with treaties kept in her temple —
  semantically the best of them and unusable inside the EU, where Fidesz makes it
  a political word.
- **Kluis, Zegel, Grootboek, Bon, Nota, Folio, Attest.** Dutch or plain-English
  nouns for the artefact. Rejected individually: Dutch-only or too long
  (`Grootboek`), generic and undefendable in Dutch (`Bon`, `Nota`), or already
  occupied by unrelated software of the same name (`Folio`, `Attest`).
