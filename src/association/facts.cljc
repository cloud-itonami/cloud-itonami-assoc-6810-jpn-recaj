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
  stop; extend `catalog`, do not invent an id/url.

  定款 (Articles of Incorporation) was verified by directly reading the
  source PDF text via the Read tool (confirming the official English
  name \"The Real Estate Companies Association of Japan (RECAJ)\" as
  printed in Article 1 of the document itself, same strictest-tier
  verification as sonpo/bankenverband/naic/jicpa/aicpa/seiho/nichibenren).
  The Voluntary Action Plan for Promoting Fair Transactions page was
  directly WebFetch-verified.")

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
     :association-rule/topic #{:fair-transaction :consumer-protection}}]})

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
      :note (str "cloud-itonami-assoc-6810-jpn-recaj Wave 0 (ADR-2607141700): "
                 (count (get catalog "recaj")) " recaj entries seeded with an "
                 "official fdk.or.jp citation. Extend "
                 "`association.facts/catalog`, never fabricate a rule id/url.")})))

(defn by-topic [assoc-slug topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis assoc-slug)))
