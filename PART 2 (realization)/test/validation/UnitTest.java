package validation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTest {

    @Test
    void testPWLength_true(){
        assertTrue(PasswordChecker.checkLength("password", 3, 10));
    }
    @ParameterizedTest
    @ValueSource(strings = {"","pa", "passwordpassword"})
    void testPWLenght_false(String pw){
        assertFalse(PasswordChecker.checkLength(pw, 3, 10));
    }

    @Test
    void testPWUpperCase_true(){
        assertTrue(PasswordChecker.checkUppercase("Password"));
    }
    @Test
    void testPWUpperCase_false(){
        assertFalse(PasswordChecker.checkUppercase("password"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"PASSWORD!", ">password", "pass word"})
    void testPWSpecialSymbols_true(String pw){
        assertTrue(PasswordChecker.checkSpecialSymbols(pw));
    }
    @ParameterizedTest
    @ValueSource(strings = {"password", "pass€word"})
    void testPWSpecialSymbols_false(String pw){
        assertFalse(PasswordChecker.checkSpecialSymbols(pw));
    }


    @ParameterizedTest
    @ValueSource(strings = {"+37000000000", "800000000"})
    void testPhoneOnlyNumbers_true(String number){
        assertTrue(PhoneValidator.validateNumbers(number));
    }
    @ParameterizedTest
    @ValueSource(strings = {"", "+370000000A0", "+@#$%^^$@#$%"})
    void testPhoneOnlyNumbers_false(String number){
        assertFalse(PhoneValidator.validateNumbers(number));
    }

    @Test
    void testPhonePrefixLocal_true(){
        assertTrue(PhoneValidator.validatePrefix("LT", "800000000"));
    }
    @Test
    void testPhonePrefix_true(){
        assertTrue(PhoneValidator.validatePrefix("LT", "+37000000000"));
    }
    @Test
    void testPhonePrefix_false(){
        assertFalse(PhoneValidator.validatePrefix("LT", "900000000"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+37000000000", "800000000"})
    void testPhonePrefix_true(String number){
        assertTrue(PhoneValidator.validateLength("LT", number));
    }
    @ParameterizedTest
    @ValueSource(strings = {"", "+123", "000000000000000000"})
    void testPhoneLength_false(String number){
        assertFalse(PhoneValidator.validateLength("LT", number));
    }

    @Test
    void testEmailAtSymbol_true(){
        assertTrue(EmailValidator.validateAt("test@email.com"));
    }
    @ParameterizedTest
    @ValueSource(strings = {"", "testemail.com", " "})
    void testEmailAtSymbol_false(String email){
        assertFalse(EmailValidator.validateAt(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"TesT@email.com", "te123st@email.com", "a!b#c$d%e&f'g*h+i-j/k=l?m^n_o`p{r|s}kk~v@email.com"})
    void testEmailSymbols_true(String email){
        assertTrue(EmailValidator.validateSymbols(email));
    }
    @ParameterizedTest
    @ValueSource(strings = {"фффф@email.com", "€@email.com"})
    void testEmailSymbols_false(String email){
        assertFalse(EmailValidator.validateSymbols(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test@email.com", "te.st@email.com"})
    void testEmailDotPlacement_true(String email){
        assertTrue(EmailValidator.validateSymbols(email));
    }
    @ParameterizedTest
    @ValueSource(strings = {".test@email.com", "test.@email.com", "te..st@email.com"})
    void testEmailDotPlacement_false(String email){
        assertFalse(EmailValidator.validateSymbols(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test@email.com", "test@EMAIL.COM", "test@123.info", "test@1.com"})
    void testEmailDomainName_true(String email){
        assertTrue(EmailValidator.validateServer(email));
    }
    @ParameterizedTest
    @ValueSource(strings = {"test@","test@#!email.com", "test@.","test@.1", "test@emailcom","test@.com", "te.gamil@com", "test.test@gmail-com","test.test@gmail....com"})
    void testEmailDomainName_false(String email){
        assertFalse(EmailValidator.validateServer(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test@email.com", "test@e-mail.com"})
    void testDomainHyphenPlacement_true(String email){
        assertTrue(EmailValidator.validateSymbols(email));
    }
    @ParameterizedTest
    @ValueSource(strings = {"test@-email.com", "test@email-.com"})
    void testDomainHyphenPlacement_false(String email){
        assertFalse(EmailValidator.validateSymbols(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test@email.com", "test@email.bosch"})
    void testEmailTLD_true(String email) {
        assertTrue(EmailValidator.validateTLD(email));
    }
    @ParameterizedTest
    @ValueSource(strings = {"test@email.1aaa"})
    void testEmailTLD_false(String email){
        assertFalse(EmailValidator.validateTLD(email));
    }

    //additional tests

    @ParameterizedTest
    @ValueSource(strings = {"passwordas!12", "paSwordelis123"})
    void testPW_false(String password){
        assertFalse(PasswordChecker.validate(password,2,5));
    }
    @ParameterizedTest
    @ValueSource(strings = {"paSswordas!12", "paSword?elis123"})
    void testPW_true(String password){
        assertFalse(PasswordChecker.validate(password,2,5));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+37062138967", "862138967"})
    void testReplaceLocalCode_true(String phone){
        assertEquals("+37062138967", PhoneValidator.replaceLocalCode("LT",phone));
    }
    @Test
    void testNoCountryCode_false(){
        assertFalse(PhoneValidator.validatePrefix("PL","+48213659487"));
    }
    @ParameterizedTest
    @ValueSource(strings = {"tes.j@com", "tes@mailcom", "test@mail.c", "test@mail.*ab"})
    void testMailTLD_false(String email){
        assertFalse(EmailValidator.validateTLD(email));
    }
    @ParameterizedTest
    @ValueSource(strings = {"t@", "tes@mailcom.","test,x@gmail.com"})
    void testMail_false(String email){
        assertFalse(EmailValidator.validateSymbols(email));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void pwValidate_ShouldReturnFalseForNullAndEmptyStrings(String input) {
        assertFalse(PasswordChecker.validate(input,0,200));
    }
    @ParameterizedTest
    @NullAndEmptySource
    void pwcLength_ShouldReturnFalseForNullAndEmptyStrings(String input) {
        assertFalse(PasswordChecker.checkLength(input,0,10));
    }
    @ParameterizedTest
    @NullAndEmptySource
    void pwSpecialSymbols_ShouldReturnFalseForNullAndEmptyStrings(String input) {
        assertFalse(PasswordChecker.checkSpecialSymbols(input));
    }
    @ParameterizedTest
    @NullAndEmptySource
    void pwUpperCase_ShouldReturnFalseForNullAndEmptyStrings(String input) {
        assertFalse(PasswordChecker.checkUppercase(input));
    }
    @ParameterizedTest
    @NullAndEmptySource
    void phonePrefix_ShouldReturnFalseForNullAndEmptyStrings(String input) {
        assertFalse(PhoneValidator.validatePrefix(input,input));
    }
    @ParameterizedTest
    @NullAndEmptySource
    void phoneLength_ShouldReturnFalseForNullAndEmptyStrings(String input) {
        assertFalse(PhoneValidator.validateLength(input,input));
    }
    @ParameterizedTest
    @NullAndEmptySource
    void phoneNumbers_ShouldReturnFalseForNullAndEmptyStrings(String input) {
        assertFalse(PhoneValidator.validateNumbers(input));
    }
    @ParameterizedTest
    @NullAndEmptySource
    void emailSymbols_ShouldReturnFalseForNullAndEmptyStrings(String input){
        assertFalse(EmailValidator.validateSymbols(input));
    }
    @ParameterizedTest
    @NullAndEmptySource
    void emailServer_ShouldReturnFalseForNullAndEmptyStrings(String input){
        assertFalse(EmailValidator.validateServer(input));
    }
    @ParameterizedTest
    @NullAndEmptySource
    void emailAt_ShouldReturnFalseForNullAndEmptyStrings(String input){
        assertFalse(EmailValidator.validateAt(input));
    }
    @ParameterizedTest
    @NullAndEmptySource
    void emailTLD_ShouldReturnFalseForNullAndEmptyStrings(String input){
        assertFalse(EmailValidator.validateTLD(input));
    }


}
