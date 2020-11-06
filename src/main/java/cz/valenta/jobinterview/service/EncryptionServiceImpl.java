package cz.valenta.jobinterview.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Service
public class EncryptionServiceImpl implements EncryptionService {

    private static final Set<Character> VOWELS = new HashSet<>(
            Arrays.asList('a', 'á', 'e', 'é', 'ě', 'i', 'í', 'o', 'ó', 'u', 'ú', 'ů'));
    private static final Locale CZECH_LOCALE = new Locale("cs_CZ");

    @Override
    public String encrypt(String inputText) {
        String result = reduceSpaces(inputText);

        StringBuilder resultSB;
        Set<Integer> indexes = getIndexesOf(result, VOWELS);

        resultSB = new StringBuilder(result).reverse();

        mixCases(resultSB, indexes);

        return resultSB.toString();
    }

    private String reduceSpaces(String inputText) {
        return inputText.replaceAll("\\s+", " ");
    }

    private void mixCases(StringBuilder resultSB, Set<Integer> indexes) {
        for (int i = 0; i < resultSB.length(); i++) {
            char charAt = resultSB.charAt(i);
            if (indexes.contains(i)) {
                resultSB.replace(i, i + 1, (charAt + "").toUpperCase(CZECH_LOCALE));
            } else {
                resultSB.replace(i, i + 1, (charAt + "").toLowerCase(CZECH_LOCALE));
            }
        }
    }

    private Set<Integer> getIndexesOf(String stringToScan, Set<Character> charsToIndex) {
        Set<Integer> indexes = new HashSet<>();

        StringBuilder resultSB = new StringBuilder(stringToScan);
        for (int i = 0; i < resultSB.length(); i++) {
            char charAt = resultSB.charAt(i);
            if (charsToIndex.contains(charAt)) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}
