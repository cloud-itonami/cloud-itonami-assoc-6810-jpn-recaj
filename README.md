# cloud-itonami-assoc-6810-jpn-recaj

Industry self-regulatory rule catalog for **The Real Estate Companies
Association of Japan** (一般社団法人 不動産協会 / RECAJ) — a 12th
industry-association-level source, and the FIRST aligned to ISIC 6810
(real estate activities), alongside
[`cloud-itonami-assoc-6419-jpn-zenginkyo`](https://github.com/cloud-itonami/cloud-itonami-assoc-6419-jpn-zenginkyo),
[`cloud-itonami-assoc-6512-jpn-sonpo`](https://github.com/cloud-itonami/cloud-itonami-assoc-6512-jpn-sonpo),
[`cloud-itonami-assoc-6612-jpn-jsda`](https://github.com/cloud-itonami/cloud-itonami-assoc-6612-jpn-jsda),
[`cloud-itonami-assoc-6419-deu-bankenverband`](https://github.com/cloud-itonami/cloud-itonami-assoc-6419-deu-bankenverband),
[`cloud-itonami-assoc-6612-usa-finra`](https://github.com/cloud-itonami/cloud-itonami-assoc-6612-usa-finra),
[`cloud-itonami-assoc-6512-usa-naic`](https://github.com/cloud-itonami/cloud-itonami-assoc-6512-usa-naic),
[`cloud-itonami-assoc-6920-jpn-jicpa`](https://github.com/cloud-itonami/cloud-itonami-assoc-6920-jpn-jicpa),
[`cloud-itonami-assoc-6920-usa-aicpa`](https://github.com/cloud-itonami/cloud-itonami-assoc-6920-usa-aicpa),
[`cloud-itonami-assoc-6419-fra-fbf`](https://github.com/cloud-itonami/cloud-itonami-assoc-6419-fra-fbf),
[`cloud-itonami-assoc-6511-jpn-seiho`](https://github.com/cloud-itonami/cloud-itonami-assoc-6511-jpn-seiho),
and
[`cloud-itonami-assoc-6910-jpn-nichibenren`](https://github.com/cloud-itonami/cloud-itonami-assoc-6910-jpn-nichibenren).
Part of the [`cloud-itonami`](https://github.com/cloud-itonami)
compliance-fact family (ADR-2607141700,
`cloud-itonami-compliance-fact-federation`, in `com-junkawasaki/root`).

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on RECAJ's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
entry not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

The catalog has **fifteen** entries and is read three ways from one file.

- `data/datascript-tx.edn` — **the source**. DataScript tx-data, and the
  file the other two readings come from (query this alongside other
  `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).
- `src/association/facts.cljk` — the same catalog as a Clojure map, with
  `spec-basis` / `coverage` / `by-topic`.
- `src/association_facts.kotoba` — **generated** from the source by
  `scripts/gen_association_facts_kotoba.cljk`; do not edit by hand. This
  is the reading that reaches the Kotoba oracle, wasm and both native
  ISAs, which the `.cljc` cannot.
- `schema/association-rule.edn` — DataScript schema.

## Checking

Three things can go wrong with a citation catalog, and each has its own
check. None of them is optional and none of them subsumes another.

```bash
clojure -M:test                                  # the readings agree
nbb scripts/gen_association_facts_kotoba.cljk --check   # the port is not stale
nbb scripts/verify_citations.cljk                # the URLs still resolve
```

The suite is hermetic, so it cannot tell you whether a URL still answers
— `verify_citations.cljs` is what goes and looks, and it exits `2` rather
than `0` when it could not read the catalog at all, because "could not
check" must not look like "checked, all fine". A non-2xx there is usually
link rot, not a bug: find where RECAJ moved the document under 規準・指針
and update the entry. Never substitute a URL that was not read off an
fdk.or.jp page.

## Provenance

Entries 1–2 were verified 2026-07-15: 定款 (Articles of Incorporation) by
directly reading the source PDF text — confirming the official English
name "The Real Estate Companies Association of Japan (RECAJ)" printed in
Article 1 itself — and the Voluntary Action Plan for Promoting Fair
Transactions page (2024-06-28) by WebFetch.

Entries 3–15 were added 2026-09-09 from the pages RECAJ files under
規準・指針 ("Standards and Guidelines"), which is the association's own
index of its self-regulatory instruments: the three アフターサービス規準
(After-Service Standards for mid/high-rise, detached and residential
land), the four 申し合わせ／申合せ／取組み agreements (condominium
confidence 2006-03-02, foundation piles 2016-01-21, barrier-free
information 2018-07-11, speculative short-term resale 2025-11-25), the
BCP guideline (2007-11-16), the two long-term repair-plan instruments,
the BIM brochure-drawing handbook, the environmental action plan
(2013-03-21) and the personal-information policy (2005-04-01). Every URL
answered 200 with the content type its extension implies.

Dates are the documents' own, read off the page that publishes each one.
Where a page prints only a year (昭和52年, the enactment the three
After-Service Standards share) or a year and month (令和6年3月, the
environmental plan's revision), **the date field is absent rather than
completed with an invented day** — an absent date means the source did
not state one, never that the document has none.

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Rule text itself
remains RECAJ's; this repo stores only citation metadata (id/title/url/
dates), not full rule text.
