import csv


class TestPractice:
    def __init__(self, file, newfile):
        self.file = file
        self.newfile = newfile

    @staticmethod
    def imc(weight, height):
        return weight / (height*height)

    @staticmethod
    def write(filename, writer):

        with open(filename, 'a', encoding='utf-8') as file:
            file.write(f'{writer}\n')

    @staticmethod
    def treatment_float(column):
        return float(column.replace(',', '.'))

    @staticmethod
    def treatment_space(names):
        list_name = [name for name in names.split(" ") if name != ""]
        return " ".join(list_name)

    def read(self):
        with open(self.file) as file:
            reader = csv.reader(file, delimiter=';')

            for index, row in enumerate(reader):
                if index > 0:
                    if row[2] or row[3] != '':
                        complete_name = self.treatment_space(row[0].capitalize()+" "+row[1].capitalize())
                        weight = self.treatment_float(row[2])
                        height = self.treatment_float(row[3])
                        result = "{} {:.2f}".format(complete_name.upper(), self.imc(weight, height))
                        print(str(result).replace(".", ","))
                        self.write(self.newfile, str(result).replace(".", ","))


if __name__ == "__main__":
    test = TestPractice('dataset.CSV', 'teste.txt')
    test.read()