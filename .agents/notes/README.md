# Documentation

Name: **Kushim**, after the earliest bookkeeper known by name
([ADR-026](adr/026-product-name.md)). Every document and crate in this repository
uses that name.

| Document | Purpose |
|----------|---------|
| [technical-design.md](technical-design.md) | v1.0 architecture, data model, compliance boundaries, security, testing. The reference for *why* the system is shaped this way. |
| [threat-model.md](threat-model.md) | Assets, trust boundaries, threats, mitigation, residual risks, and the tests behind each claim. |
| [accounting-design.md](accounting-design.md) | v1.1 accounting layer: general ledger, VAT return preparation, bank reconciliation. |
| [implementation-plan.md](implementation-plan.md) | Milestones, effort estimates, release trains, quality gates, first-two-weeks task list. |
| [mobile-design.md](mobile-design.md) | Proposed Android-first mobile client: Kotlin/Compose Multiplatform, UniFFI, application layer, adaptive UI, mobile security, build and milestones. |
| [adr/](adr/README.md) | Architecture decision records 001–026. |
| [spikes/](spikes/README.md) | Time-boxed investigations and their findings. |

The original brief lives at `../../spec.md`. The design document supersedes it
where the two disagree; §2 of the design document lists every correction and the
reasoning behind it.

Document status: drafts, 2026-10-27. Changes to a recorded decision require a
new or amended ADR (technical-design §17, accounting-design §14).
