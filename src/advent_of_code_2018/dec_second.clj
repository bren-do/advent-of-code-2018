(ns advent-of-code-2018.dec-second)

(def input
  (-> "rvefnvyxzbodgpnpkumawhijsc
  rvefqtyxzsddglnppumawhijsc
  rvefqtywzbodglnkkubawhijsc
  rvefqpyxzbozglnpkumawhiqsc
  rvefqtyxzbotgenpkuyawhijsc
  rvefqtyxzbodglnlkumtphijsc
  rwefqtykzbodglnpkumawhijss
  rvynqtyxzbodglnpkumawrijsc
  rvefqtyxlbodgcnpkumawhijec
  rvefqtyxzbodmlnpnumawhijsx
  rvefqtyxzbqdbdnpkumawhijsc
  rvefqtyxzlodblnpkuiawhijsc
  rvefqtyizrodelnpkumawhijsc
  rveffjyxzgodglnpkumawhijsc
  rvefqjyxzbodalnpkumadhijsc
  rvefqtidzbodglnpkumawhdjsc
  hvefqtygzbodglnpkumawhijfc
  rzefqtyxzbodglfhkumawhijsc
  rmefqtyxzbolglnpkumaehijsc
  rnefqqyxzbodglnhkumawhijsc
  rvwfqvyxzbodglnpcumawhijsc
  rvefqtyxzbokgltpkumavhijsc
  rvefciyxzbodglnmkumawhijsc
  rvefptyxzbodglnpkuhashijsc
  rvefqtyxzrodglnpkxmawhiqsc
  rvefqtyxzbotglnpkumawriwsc
  rvufqtyxzbodglnplumawhijvc
  rvefutykzbodglnpkumaahijsc
  rvefqtyxqbodgllprumawhijsc
  rvegqttxzbodgllpkumawhijsc
  dvefqtyxzsodglnpkumawdijsc
  rvefqtyxkbodglnfkumawhijsj
  rvefqtyxzbodnlnpcumawhijnc
  rvefqtyxzbodglfpkuocwhijsc
  rvecqtyxzbbdganpkumawhijsc
  rvefytyxzbodglnpkubgwhijsc
  rvefxtyazbomglnpkumawhijsc
  rvefqgyxzbodglnpkumawyiksc
  avefqtyxzbodglnfkummwhijsc
  fvefqtyxzbbdglnpkumswhijsc
  rvefqtyxzxodglnpkumuuhijsc
  rvezqtyxzbydclnpkumawhijsc
  rvefqtyxzbohglnpkumawdijjc
  rvejqtyxzbodrlnpkumawhijsd
  rvefitzxzbxdglnpkumawhijsc
  rvefutyxzbvdglnikumawhijsc
  rvefqtyazbodgqnbkumawhijsc
  rvefqtyxzbolglnpkwmajhijsc
  rvefqtyxzjodglnpgwmawhijsc
  rvefhtyxzbodglbpaumawhijsc
  mvexqtyxzbodglnpkumawrijsc
  rvefqtyxwbodglnpkumawhbxsc
  rvefqtyxzbodgsnpkudawsijsc
  rvwfqtyxzbonglnwkumawhijsc
  rvefqtyxzjodglnpkfmawhwjsc
  rvefqtyxzbodglntkumughijsc
  rvefctyxzbodglnpkumawhiwsx
  avefqtyvzbodglnpkumawhijsb
  rfefqtyxzlodglnphumawhijsc
  rvefqtyxzfowglnpkumaehijsc
  rvhfvtyxzbodgqnpkumawhijsc
  rfefqtyxzbodglapkumuwhijsc
  rvefqclxzbodglnzkumawhijsc
  qvefqtyxzbodglnckumcwhijsc
  rvefqtyxzkodglnpkymawgijsc
  rvefqtyxzbodgfnpkumafhizsc
  rvefqtyxzbodglnxkumavhijsf
  rvevqtyxzbodgpnpkurawhijsc
  rvefqtyxziodglnpkubawhijss
  rrefqtpxzyodglnpkumawhijsc
  rvefqfyxzbodglcpkxmawhijsc
  rvefdtyxzbodglnpkumvwhijsn
  rverqtyxzbodglnpkwmawhijuc
  rvecjtyxzboxglnpkumawhijsc
  rvefqtyxzbodglnpkqmaxhifsc
  rtnfqtyxzbodglnpkumawhijmc
  lvefqtyxzbodelnpkumawhijsz
  dvefqtyxzbbdgvnpkumawhijsc
  rvefqlyhzbodglnpkumtwhijsc
  roefqtyxlbodglnpkumawhyjsc
  rvefqsydzjodglnpkumawhijsc
  rveybtyxzbodglnpkumawhijsn
  rvefqtyhzbodgvnpmumawhijsc
  rvefqxyazboddlnpkumawhijsc
  vvefqtyxzbohglqpkumawhijsc
  reefhtyxzbodglnpkkmawhijsc
  rvefqtyxzbodglnpkulowhijrc
  rveqqtyxzbodgknpkumawhijsk
  jvefqtqxzbodglnpkumawiijsc
  rvefqtyxzboxglnpvuqawhijsc
  rvefquyxzbodglwwkumawhijsc
  rvefqtyxzbodnlnpkumawhgjbc
  rvdfqthxdbodglnpkumawhijsc
  rvefqtyxzbodllnpkumawhujsb
  evefqtyxzboyglnpkumowhijsc
  rvefktyxzbomglnpzumawhijsc
  rvefqtyxzbodhlnnkrmawhijsc
  rvefqtyxrbodglnpkujaehijsc
  rvefqtyzzbodglnpkumrwhijsb
  evefqtyxzpodglfpkumawhijsc
  rvefqtyxibodglkpyumawhijsc
  rrefqtyxzbodglnpkudawhajsc
  rvifqtyxzbodglxpkumawhijlc
  rxefqtyxzbedglnpkumawhijsp
  rvnfqtyxzbopglnpkuqawhijsc
  rvefqtyxkbodglnpoumawoijsc
  dvefwtyxzbodglnpksmawhijsc
  rvkfqtyxzbodglnpkdmawhijsa
  rcefytyxzzodglnpkumawhijsc
  rvefqtkxzbodglnpktqawhijsc
  nvezqhyxzbodglnpkumawhijsc
  rrefqtyxzbodgunpkumpwhijsc
  rvefqtaxzbodgknpkumawhijic
  pvefqtyxzbodglnpkuxawsijsc
  rvefqtyxzbodglkpvumawhjjsc
  wvefqtyxzkodglnpkumawhhjsc
  rzefqtyxzbotglnpkumawhxjsc
  rvefqtxpzbodglnpkumawzijsc
  bgefqtyxzbodglnpkrmawhijsc
  rvefqlyxzbodglnpkumilhijsc
  cbefqtyxzbodglnpkumawhiesc
  rvefqtyxzbydelnpkumahhijsc
  rvefntyxzbodglnpkumaehijsw
  rverqtyxztodglopkumawhijsc
  rvefqtyxzdodgwrpkumawhijsc
  rvefqtyxibodglnikumawhtjsc
  qvafqtyxzbodglnpkurawhijsc
  rvefqtyxwbodglnpaumawoijsc
  rvefqtyxzoodglndknmawhijsc
  rvdfqtlxzyodglnpkumawhijsc
  rvefqtyxzbodglngfumawhinsc
  rsefqtyxzbodglnpkumawhijek
  rvoestyxzbodglnpkumawhijsc
  svefqtyxzboaglnprumawhijsc
  rvefqtybzbodgwnpkumawwijsc
  rvefqtyxzdwdglnpkvmawhijsc
  rvlfqtyxzbodglnpkrmawhixsc
  rvefqtyxwbodglepkumawhijsd
  rvefqtbxzbodglnqkumawhijmc
  rvefqtzxzbodglnpkumuzhijsc
  rvefqtyxzbodglnpkumawzwnsc
  rvwfqtyxzboiglnpkumawhijsg
  rtehotyxzbodglnpkudawhijsc
  rvegqtyxzbodglnpyumawhijsl
  rvecqtyxzbsdglnpkumawhojsc
  rvefqtyxzbodmlnpkumaghijfc
  rvefqtyxzxodglnpkumanvijsc
  rvefqtyxzbodglnbiugawhijsc
  lvefqtlxzbodglnplumawhijsc
  rvefqtyxvbodglnpkumaldijsc
  rmefqtyxzbodgvnpkuuawhijsc
  rvefqtyxzbodglnpkymeuhijsc
  rvefqtyxzuodganpsumawhijsc
  rxefqtyxzbodglnpkumgwhijwc
  rvefgtyxzbodglnpkudawxijsc
  ahefqtyxzbodglnpkumawhejsc
  rfefqtyxzbzdglnpkusawhijsc
  rvefqtyszqodgljpkumawhijsc
  rvefqtylzboiglnpkumrwhijsc
  rvefqtyxzltdglnpkumawhijsu
  rbefqtyxzbodglnpqumawhijsi
  rvefqtyozpodglnpkumawhijsa
  zvefqtyxzpopglnpkumawhijsc
  rvefqtyxzbodglnfkqmawhijsp
  rvefqtyxzbodgliakumawhijsf
  rvefqtymzrodgfnpkumawhijsc
  ivejqtyxzbodglnpkumawhijuc
  rvefqtyxzbodflnpkxwawhijsc
  dvrfqtyxzbodglnpkumashijsc
  rqefqtyxzbwdglnpkumawvijsc
  tvefqtkxzbodgltpkumawhijsc
  rvefdtyxzbodguxpkumawhijsc
  rveqqtyxvbodglnykumawhijsc
  rvefqtypzcovglnpkumawhijsc
  rvefqnyxzbosglnpkumdwhijsc
  rvefstjxzbodslnpkumawhijsc
  rvefqzyxzpodglnpkummwhijsc
  rvefqkyxzbodglnhgumawhijsc
  rvufqvyxzbodklnpkumawhijsc
  rvefotyxzhodglnpkumawhijsk
  rvefqtyxzbokglnpkumawvcjsc
  lvefqtyxzbolglnpkumawoijsc
  rvefqtywzoodglfpkumawhijsc
  rvehqtqxzbodglnpkumawhcjsc
  rqefqtyxzbodolnpkumjwhijsc
  rvefqtyxzbodglrpkunawgijsc
  rvefqtyxzbodglamkumawdijsc
  rvefvtyzzbodllnpkumawhijsc
  rvefqtyxzbldglnpfcmawhijsc
  rvefppyxzbodglnpkucawhijsc
  rvefquyuzbodglnpkumkwhijsc
  rvefqtyxzbodgqxpkumawhivsc
  rtefotyxzbodglnpkudawhijsc
  rvefqtyxzbodgbnmkuzawhijsc
  ivefqtyxzbodgsnpkumzwhijsc
  rvhfqtyxzbodolnpkumawhijsz
  rvefvtyxzbodwlnpkusawhijsc
  riemqtyxzbodglnpkumawhiasc
  rvtfqtyxzbqdglnpkumawuijsc
  raesqtyxzbodglnpkumawhijsj
  rvefqtyxzbodalmpkumawhihsc
  rvefqtlxzbodgznpkkmawhijsc
  rvefqbyxzbodglgpkubawhijsc
  rvefqtyxnbodgxnpkumswhijsc
  rvefqtyxzkodvlnukumawhijsc
  rvefqtyzzbocglnpkumafhijsc
  rvhfqtyxzbodglmpkumgwhijsc
  rvsfrtyxzbodnlnpkumawhijsc
  rvefqtyxzbxdglnpkujcwhijsc
  rvefqtyvzrodglnphumawhijsc
  reetatyxzbodglnpkumawhijsc
  rvefqtyxzbodglnpzumaoqijsc
  ovefqtyyzbodglnvkumawhijsc
  rvefqbyxzbodnlnpkumawhijsi
  xvefqtyxzbodgrnpkumawrijsc
  rvebqtyxzbodglnpkumazhiasc
  rqeretyxzbodglnpkumawhijsc
  rvefqtyxzyodglapkumvwhijsc
  rvesqxyxzbodglnpvumawhijsc
  rvefqtyxeborglnpkufawhijsc
  rvecqtyxzbodflnpkumawnijsc
  rvefdpyxtbodglnpkumawhijsc
  rvefqtyfzbodclnpkymawhijsc
  rvefqtywzbodglnpxumawhiusc
  rvefqtyxzbodglnpkumawzbjwc
  rvewqtyxdbodglnpxumawhijsc
  rvefqtyxzgocglnpkgmawhijsc
  rvufqtyxzbodggnpkuzawhijsc
  rvefqtynzlodgllpkumawhijsc
  rvedqtyxzbodghnpkumawhujsc
  rvefqtyxlbodgnnpkpmawhijsc
  rvefqtyxzboqglnpkzmawhijec
  rvefqtyxzbodglnpkfmwwyijsc
  rwefqtkxzbodzlnpkumawhijsc
  rvefqtyxvbodglnpkufawhyjsc
  rvefqtyxzbodgltpkumawhqmsc
  rvefctyxzbodglfpkumathijsc
  rvefqtyxzbodgfnpkuuawhijfc
  rvefqttxzbodglnpmumawhijwc
  rvefqtyxzbodglnpkqmawhihsj
  rvefqtyxzbsdglcnkumawhijsc
  rvbiqtyxzbodglnpkumawhijlc
  rnefqtylzvodglnpkumawhijsc
  mvefqtyxzbddglnpkumcwhijsc
  rvefwtyxzbodglnpkgmawhijxc
  rvefqtyxljodglnpkumxwhijsc
  rvefqtyxzbodglnpkuprwhijsd
  rcxfqtyxzbldglnpkumawhijsc
  rvetqtyxzbojglnpkumewhijsc
  rvxfqtyxzbtdglnpkbmawhijsc"
      (clojure.string/replace #" " "")
      (clojure.string/split #"\n")))

(def test-data-checksum
  ["abcdef"
   "bababc"
   "abbcde"
   "abcccd"
   "aabcdd"
   "abcdee"
   "ababab"])

(defn get-checksum
  "I don't do a whole lot."
  [x]
  (let [{:keys [twos threes] :as output}
        (reduce (fn [o s]
                  (let [freqs (-> s frequencies vals frequencies)]
                    (cond-> o
                      (get freqs 2) (update :twos inc)
                      (get freqs 3) (update :threes inc)))) {:twos 0
                                                             :threes 0} x)]
    (* twos threes)))

(def test-data-ids
  ["abcde"
   "fghij"
   "klmno"
   "pqrst"
   #_"fguij"
   "axcye"
   "wvxyz"
   "fzgij"
   "fgjij"])



(defn remove-chars-that-aren't-equal-at-each-position
  [a b]
  (filter identity (map #(when (= % %2) %) a b)))

(defn find-id
  [x]
  (first
   (mapcat
    (fn [outer-str]
      (keep
       (fn [inner-str]
         (when
             (= (count (remove-chars-that-aren't-equal-at-each-position outer-str inner-str)) (dec (count outer-str))) ;; when we remove chars that aren't equal at each position the resulting sequence is smaller by only one.
           (apply str (remove-chars-that-aren't-equal-at-each-position outer-str inner-str)))) ;; find resulting string of removing chars that aren't equal at each position
       x))
    x)))
