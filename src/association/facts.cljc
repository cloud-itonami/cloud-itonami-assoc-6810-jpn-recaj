(ns association.facts
  "Industry self-regulatory rule catalog for The Real Estate Companies
  Association of Japan (一般社団法人 不動産協会 / RECAJ) -- a 12th
  industry-association-level source (see cloud-itonami-assoc-6419-jpn-zenginkyo,
  -6512-jpn-sonpo, -6612-jpn-jsda, -6419-deu-bankenverband, -6612-usa-finra,
  -6512-usa-naic, -6920-jpn-jicpa, -6920-usa-aicpa, -6419-fra-fbf,
  -6511-jpn-seiho, -6910-jpn-nichibenren for the first eleven) per
  ADR-2607141700 (cloud-itonami-compliance-fact-federation). The FIRST
  entry aligned to ISIC 6810 (real estate activities) -- a new industry
  code for this family. Every entry cites an OFFICIAL fdk.or.jp URL --
  never fabricated. A rule not in this table has NO spec-basis, full
  stop; extend the catalog, do not invent an id/url.

  `data/datascript-tx.edn` holds the same fifteen entries and is the file
  `scripts/gen_association_facts_kotoba.cljs` generates the Kotoba port
  from; `association.facts-test` asserts this map and that file agree
  field for field, so the three readings cannot drift apart silently.

  Provenance. Entries 1-2 were verified 2026-07-15: 定款 (Articles of
  Incorporation) by reading the source PDF text directly -- confirming the
  official English name \"The Real Estate Companies Association of Japan
  (RECAJ)\" as printed in Article 1 of the document itself, the same
  strictest-tier verification as sonpo/bankenverband/naic/jicpa/aicpa/
  seiho/nichibenren -- and the Voluntary Action Plan page by WebFetch.

  Entries 3-15 were added 2026-09-09 from the pages RECAJ files under
  規準・指針 (\"Standards and Guidelines\"), which is the association's own
  index of its self-regulatory instruments: the three アフターサービス規準
  (After-Service Standards), the 申し合わせ/申合せ agreements on
  condominium confidence, foundation piles, barrier-free information and
  speculative short-term resale, the BCP guideline, the two long-term
  repair-plan instruments, the BIM drawing handbook, the environmental
  action plan, and the personal-information policy. Each URL was fetched
  and answered 200 with the content type its extension implies;
  `nbb scripts/verify_citations.cljs` re-checks that on demand.

  The dates are the documents' own, read off the page that publishes each
  one -- the board-approval dates the After-Service Standards print
  (2000-04-21 for mid/high-rise, 2000-07-14 for detached), and the single
  publication dates the agreements carry (2006-03-02, 2016-01-21,
  2018-07-11, 2025-11-25, 2007-11-16, 2013-03-21, 2005-04-01).

  Where a page prints only a year or a year and month -- the 昭和52年
  (1977) enactment the three After-Service Standards share, the 令和6年3月
  revision of the environmental action plan, the 令和6年度 BIM work -- the
  date field is ABSENT rather than completed with an invented day. The
  two long-term repair-plan instruments print no date at all and carry
  none here. An absent date means the source did not state one; it never
  means the document has none.

  RECAJ publishes these in Japanese. Titles carry the Japanese text the
  association prints followed by a parenthesized English rendering for
  readers of this catalog; the Japanese governs.")

(def catalog
  "assoc-slug -> vector of self-regulatory rule entries."
  {"recaj"
   [{:association-rule/id "recaj.articles-of-incorporation"
     :association-rule/title "定款 (Articles of Incorporation)"
     :association-rule/association "recaj"
     :association-rule/isic "6810"
     :association-rule/country "JPN"
     :association-rule/kind :self-regulatory-code
     :association-rule/url "http://www.fdk.or.jp/f_outline/pdf/teikan.pdf"
     :association-rule/url-provenance :official-association-site
     :association-rule/retrieved-at "2026-07-15"
     :association-rule/topic #{:governance}}
    {:association-rule/id "recaj.voluntary-action-plan-fair-transactions"
     :association-rule/title "適正取引の推進に向けた自主行動計画 (Voluntary Action Plan for Promoting Fair Transactions)"
     :association-rule/association "recaj"
     :association-rule/isic "6810"
     :association-rule/country "JPN"
     :association-rule/kind :self-regulatory-code
     :association-rule/url "https://fdk.or.jp/k_etc/plan.html"
     :association-rule/url-provenance :official-association-site
     :association-rule/last-revised-date "2024-06-28"
     :association-rule/retrieved-at "2026-07-15"
     :association-rule/topic #{:fair-transaction :consumer-protection}}
    {:association-rule/id "recaj.after-service-standard-mid-high-rise"
     :association-rule/title "中高層住宅アフターサービス規準 (After-Service Standard for Mid- and High-Rise Housing)"
     :association-rule/association "recaj"
     :association-rule/isic "6810"
     :association-rule/country "JPN"
     :association-rule/kind :self-regulatory-code
     :association-rule/url "https://www.fdk.or.jp/k_afterservice/index.html"
     :association-rule/url-provenance :official-association-site
     :association-rule/last-revised-date "2000-04-21"
     :association-rule/retrieved-at "2026-09-09"
     :association-rule/topic #{:after-service :consumer-protection}}
    {:association-rule/id "recaj.after-service-standard-detached-house"
     :association-rule/title "戸建住宅アフターサービス規準 (After-Service Standard for Detached Housing)"
     :association-rule/association "recaj"
     :association-rule/isic "6810"
     :association-rule/country "JPN"
     :association-rule/kind :self-regulatory-code
     :association-rule/url "https://www.fdk.or.jp/k_afterservice/token.html"
     :association-rule/url-provenance :official-association-site
     :association-rule/last-revised-date "2000-07-14"
     :association-rule/retrieved-at "2026-09-09"
     :association-rule/topic #{:after-service :consumer-protection}}
    {:association-rule/id "recaj.after-service-standard-residential-land"
     :association-rule/title "宅地アフターサービス規準 (After-Service Standard for Residential Land)"
     :association-rule/association "recaj"
     :association-rule/isic "6810"
     :association-rule/country "JPN"
     :association-rule/kind :self-regulatory-code
     :association-rule/url "https://www.fdk.or.jp/k_afterservice/takuti.html"
     :association-rule/url-provenance :official-association-site
     :association-rule/retrieved-at "2026-09-09"
     :association-rule/topic #{:after-service :consumer-protection}}
    {:association-rule/id "recaj.condominium-trust-restoration-agreement"
     :association-rule/title "マンションの信頼性を回復するための取り組みに関する申し合わせ (Agreement on Measures to Restore Confidence in Condominiums)"
     :association-rule/association "recaj"
     :association-rule/isic "6810"
     :association-rule/country "JPN"
     :association-rule/kind :self-regulatory-code
     :association-rule/url "https://www.fdk.or.jp/k_etc/pdf/18mansion.pdf"
     :association-rule/url-provenance :official-association-site
     :association-rule/established-date "2006-03-02"
     :association-rule/retrieved-at "2026-09-09"
     :association-rule/topic #{:building-safety :consumer-protection}}
    {:association-rule/id "recaj.foundation-pile-construction-measures"
     :association-rule/title "基礎ぐい工事問題に関する対策委員会の中間とりまとめ報告書を踏まえた当協会の取り組みについて (Association Measures Following the Interim Report on the Foundation Pile Construction Problem)"
     :association-rule/association "recaj"
     :association-rule/isic "6810"
     :association-rule/country "JPN"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.fdk.or.jp/news/pdf/houdoupress_20160121.pdf"
     :association-rule/url-provenance :official-association-site
     :association-rule/established-date "2016-01-21"
     :association-rule/retrieved-at "2026-09-09"
     :association-rule/topic #{:building-safety :consumer-protection}}
    {:association-rule/id "recaj.barrier-free-information-agreement"
     :association-rule/title "共同住宅のバリアフリーに関する情報提供の取組に関する申合せ (Agreement on Providing Barrier-Free Information for Multi-Unit Housing)"
     :association-rule/association "recaj"
     :association-rule/isic "6810"
     :association-rule/country "JPN"
     :association-rule/kind :self-regulatory-code
     :association-rule/url "https://www.fdk.or.jp/k_etc/pdf/barrierfree_1807.pdf"
     :association-rule/url-provenance :official-association-site
     :association-rule/established-date "2018-07-11"
     :association-rule/retrieved-at "2026-09-09"
     :association-rule/topic #{:accessibility :consumer-protection}}
    {:association-rule/id "recaj.speculative-short-term-resale-measures"
     :association-rule/title "分譲マンションの投機的短期転売問題にかかる取組みについて (Measures on Speculative Short-Term Resale of Condominium Units)"
     :association-rule/association "recaj"
     :association-rule/isic "6810"
     :association-rule/country "JPN"
     :association-rule/kind :self-regulatory-code
     :association-rule/url "https://www.fdk.or.jp/k_etc/pdf/tankitenbai_2511.pdf"
     :association-rule/url-provenance :official-association-site
     :association-rule/established-date "2025-11-25"
     :association-rule/retrieved-at "2026-09-09"
     :association-rule/topic #{:fair-transaction :consumer-protection}}
    {:association-rule/id "recaj.business-continuity-plan-guideline-office"
     :association-rule/title "不動産協会事業継続計画ガイドライン～オフィスビル賃貸事業編～ (RECAJ Business Continuity Plan Guideline: Office Building Leasing Edition)"
     :association-rule/association "recaj"
     :association-rule/isic "6810"
     :association-rule/country "JPN"
     :association-rule/kind :practice-guidance
     :association-rule/url "https://www.fdk.or.jp/k_etc/guideline.html"
     :association-rule/url-provenance :official-association-site
     :association-rule/established-date "2007-11-16"
     :association-rule/retrieved-at "2026-09-09"
     :association-rule/topic #{:business-continuity :disaster-preparedness}}
    {:association-rule/id "recaj.long-term-repair-plan-preparation-guideline"
     :association-rule/title "長期修繕計画の作成指針 (Guideline for Preparing a Long-Term Repair Plan)"
     :association-rule/association "recaj"
     :association-rule/isic "6810"
     :association-rule/country "JPN"
     :association-rule/kind :practice-guidance
     :association-rule/url "https://www.fdk.or.jp/k_plan/tyouki.html"
     :association-rule/url-provenance :official-association-site
     :association-rule/retrieved-at "2026-09-09"
     :association-rule/topic #{:building-maintenance :consumer-protection}}
    {:association-rule/id "recaj.repair-reserve-fund-policy"
     :association-rule/title "長期修繕計画及び適正な修繕積立金のあり方 (Policy on Long-Term Repair Plans and Appropriate Repair Reserve Funds)"
     :association-rule/association "recaj"
     :association-rule/isic "6810"
     :association-rule/country "JPN"
     :association-rule/kind :self-regulatory-code
     :association-rule/url "https://www.fdk.or.jp/k_plan/tsumitate.html"
     :association-rule/url-provenance :official-association-site
     :association-rule/retrieved-at "2026-09-09"
     :association-rule/topic #{:building-maintenance :consumer-protection}}
    {:association-rule/id "recaj.bim-apartment-brochure-drawing-handbook"
     :association-rule/title "不動産協会標準_集合住宅パンフレット図面作成の手引 (RECAJ Standard: Handbook for Preparing Multi-Unit Housing Brochure Drawings)"
     :association-rule/association "recaj"
     :association-rule/isic "6810"
     :association-rule/country "JPN"
     :association-rule/kind :practice-guidance
     :association-rule/url "https://www.fdk.or.jp/k_bim/pdf/bim_tebiki.pdf"
     :association-rule/url-provenance :official-association-site
     :association-rule/retrieved-at "2026-09-09"
     :association-rule/topic #{:digital-standard}}
    {:association-rule/id "recaj.real-estate-industry-environment-action-plan"
     :association-rule/title "不動産業環境実行計画～サステナブルなまちづくりに向けて～ (Real Estate Industry Environmental Action Plan: Toward Sustainable Town Development)"
     :association-rule/association "recaj"
     :association-rule/isic "6810"
     :association-rule/country "JPN"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.fdk.or.jp/k_environment/plan_sustainable.html"
     :association-rule/url-provenance :official-association-site
     :association-rule/established-date "2013-03-21"
     :association-rule/retrieved-at "2026-09-09"
     :association-rule/topic #{:environment}}
    {:association-rule/id "recaj.personal-information-handling-policy"
     :association-rule/title "個人情報の取扱いについて (Policy on the Handling of Personal Information)"
     :association-rule/association "recaj"
     :association-rule/isic "6810"
     :association-rule/country "JPN"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.fdk.or.jp/kojin/handling.html"
     :association-rule/url-provenance :official-association-site
     :association-rule/established-date "2005-04-01"
     :association-rule/retrieved-at "2026-09-09"
     :association-rule/topic #{:privacy :governance}}]})

(defn spec-basis [assoc-slug] (get catalog assoc-slug))

(defn coverage
  ([] (coverage (keys catalog)))
  ([slugs]
   (let [have (filter catalog slugs)
         missing (remove catalog slugs)]
     {:requested (count slugs)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (str "cloud-itonami-assoc-6810-jpn-recaj (ADR-2607141700): "
                 (count (get catalog "recaj")) " recaj entries, each with an "
                 "official fdk.or.jp citation. Extend "
                 "`association.facts/catalog`, never fabricate a rule id/url.")})))

(defn by-topic [assoc-slug topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis assoc-slug)))
