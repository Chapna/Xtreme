/*
 * In The Name Of God
 * ========================================
 * [] File Name : XtremeInSecurity.c
 *
 * [] Creation Date : 24-10-2015
 *
 * [] Created By : Parham Alvani (parham.alvani@gmail.com)
 * =======================================
*/
/*
 * Copyright (c) 2015 Parham Alvani.
*/
#include <stdio.h>
#include <string.h>
#include <openssl/sha.h>
#include <openssl/bio.h>
#include <openssl/evp.h>
#include <openssl/buffer.h>
#include <stdint.h>

int Base64Encode(const unsigned char* buffer, size_t length, char** b64text) {
	BIO *bio, *b64;
	BUF_MEM *bufferPtr;

	b64 = BIO_new(BIO_f_base64());
	bio = BIO_new(BIO_s_mem());
	bio = BIO_push(b64, bio);

	//BIO_set_flags(bio, BIO_FLAGS_BASE64_NO_NL); //Ignore newlines - write everything in one line
	BIO_write(bio, buffer, length);
	BIO_flush(bio);
	BIO_get_mem_ptr(bio, &bufferPtr);
	BIO_set_close(bio, BIO_NOCLOSE);
	BIO_free_all(bio);

	*b64text=(*bufferPtr).data;

	return (0);
}

void inc(char input[], int len)
{
	int i;
	
	input[0]++;
	for (i = 0; i < len; i++) {
		if (input[i] > 'z') {
			input[i] = '0';
			if (i + 1 < len)
				input[i + 1]++;
		} else if (input[i] > '9' && input[i] < 'a') {
			input[i] = 'a';
		}
	}
}

int main(int argc, char *argv[])
{
	// char base[] = "000000000";
	char base[] = "password1";

	do {
		char pre_hash[20] = "IEEE";
		char hash[1024];
		char *base64;

		strcat(pre_hash, base);
		strcat(pre_hash, "Xtreme");
		
		SHA512_CTX ctx;
		SHA384_Init(&ctx);
		SHA384_Update(&ctx, pre_hash, 20);
		SHA384_Final(hash, &ctx);


		Base64Encode(hash, SHA256_DIGEST_LENGTH, &base64);			

		printf("%s --> %s --> %s\n", base, pre_hash, base64);

		inc(base, 9);
	} while (strcmp(base, "000000000"));
}
